import React, { Component } from 'react';
import Vehicle from './Vehicle.js';
import axios from 'axios';
import './VehilceList.css';

class VehicleList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            vehicleList:[]
        };
    }

    componentDidMount() {
        var self = this;
        console.log('--> Triggering from XHR');
        //const vehicleListURL = "http://swapi.co/api/planets/";
        const vehicleListURL = "http://localhost:8080/vehicles";
        axios.get(vehicleListURL)
            .then(function(response){
                console.log(response);
                if(response.data){
                    self.setState({
                        vehicleList : response.data
                    })
                }
            })
            .catch(function (error) {

            });
    }



    render() {
        let vehicleListData;

        if(this.state.vehicleList){
            vehicleListData = this.state.vehicleList.map(vehicleData => {
                return(
                    <Vehicle key={vehicleData.vin} metaVehicleData={vehicleData} />
                );
            })
        }

        console.log('Inside vehicle list render method '+ vehicleListData);
        return (
            <div className="VehicleList">
                {vehicleListData}
            </div>
        );
    }
}

export default VehicleList;