import React, { Component } from 'react';
import Vehicle from './Vehicle.js';
import axios from 'axios';
import './Vehicle.css';


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
        const vehicleListURL = "http://localhost:8080/vehicles";
        axios.get(vehicleListURL)
            .then(function(response){
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
        if(this.state.vehicleList){
            return(
                <div>
                    <Vehicle metaData={this.state.vehicleList} />
                </div>
            );
        }

        return (
            <div className="VehicleList">
                {this.state.vehicleList}
            </div>
        );
    }
}

export default VehicleList;