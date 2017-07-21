import React, { Component } from 'react';
import axios from 'axios';
import Vehicle from './Vehicle.js';
import './VehilceList.css';

class VehicleList extends Component {


    render() {

        console.log('--> Mounted in Render method');
        return (
            <div className="VehicleList">
                <h2>I am Vehicle List</h2>
                <Vehicle />
                <Vehicle />
                <Vehicle />
                <Vehicle />
            </div>
        );
    }
}

export default VehicleList;