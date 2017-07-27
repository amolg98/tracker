import React, { Component } from 'react';
import axios from 'axios';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import AlertsListByVIN from './AlertsListByVIN';
import './AlertsList.css';

class VinListForAlerts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            VehiclesListByVIN:[],
            AlertsForVehicles:[]
        };
    }

    componentDidMount() {
        var options = [];
        var self = this;
        console.log('--> Triggering from XHR in ByVIN');
        const VehiclesListURL = "http://localhost:8080/vehicles";
        axios.get(VehiclesListURL)
            .then(function(response){
                console.log(response);
                if(response.data){
                    response.data.forEach(function (optionValue) {
                        options.push(optionValue["vin"]);
                    });
                    self.setState({
                        VehiclesListByVIN : options
                    })
                }
            })
            .catch(function (error) {

            });
    }


    onSelectThis(vin){
        console.log('--> Triggering from XHR in ByVIN');
        const VehiclesListURL = "http://localhost:8080/alerts/"+vin["value"];
        console.log(VehiclesListURL);
        var self = this;
        axios.get(VehiclesListURL)
            .then(function(response){
                console.log(response);
                if(response.data){
                    self.setState({
                        AlertsForVehicles : response.data
                    })
                }
            })
            .catch(function (error) {

            });
    }

    render(){
        const options = this.state.VehiclesListByVIN;
        console.log('--> Mounted in Render method');

        return (
            <div className="VinByAlert" id="VinByAlert">
                <h2>Vehicle Alerts Data</h2>
                <div className="drop-down" >
                    <Dropdown options={options} key={options.vin} onChange={this.onSelectThis.bind(this)} value={null} placeholder="Select a Vehicle Number" />
                </div>
                <div className="AlertListByVIN" >
                    <AlertsListByVIN nameD={this.state.AlertsForVehicles} />
                </div>
            </div>
        );
    }

}

export default VinListForAlerts;