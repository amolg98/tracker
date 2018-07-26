import React, { Component } from 'react';
import axios from 'axios';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import Map from './Map';
import './map.css';

class VehListForMap extends Component {
    constructor(props) {
        super(props);
        this.state = {
            VehiclesListByVIN:[],
            MapData:[]
        };
    }

    componentDidMount() {
        var options = [];
        var self = this;
        console.log('--> Triggering from XHR in Map Data');
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
        //var options = [];
        console.log('--> Triggering from XHR in Map in ByVIN');
        const VehiclesListURL = "http://localhost:8080/readings/"+vin["value"];
        console.log(VehiclesListURL);
        var self = this;
        axios.get(VehiclesListURL)
            .then(function(response){
                console.log(response);
                if(response.data){
                    self.setState({
                        MapData : response.data
                    })
                }
            })
            .catch(function (error) {

            });
    }

    render(){
        const options = this.state.VehiclesListByVIN;

        return (
            <div className="VinByAlert" id="VinByAlert">
                <h2>Vehicle Location Details</h2>
                <div className="drop-down" >
                    <Dropdown options={options} key={options.vin} onChange={this.onSelectThis.bind(this)} value={null} placeholder="Select a Vehicle Number" />
                </div>
                <div className="simpleMap">
                    <Map center={{ lat: 29.617124, lng: -82.373750 }}
                         zoom={4}
                         containerElement={
                             <div style={{ height: `100%`, width:`100%` }} />
                         }
                         mapElement={
                             <div style={{ height: `100%`, width:`100%` }} />
                         }
                         markers={this.state.MapData}
                    />
                </div>
            </div>
        );
    }

}

export default VehListForMap;