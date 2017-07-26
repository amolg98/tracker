import React, { Component } from 'react';

import VehicleList from './Vehicle/VehicleList.js';
import AlertsList from "./Alerts/AlertsList.js";
import VinListForAlerts from "./Alerts/VinListForAlerts";
import VehListForMap from "./Map/VehListForMap";

import './App.css';


class App extends Component {

    render() {
        console.log('--> Mounted in Render method');

        return (
            <div className="App">
                <div className="App-header">
                    <h2>Welcome to React</h2>
                </div>
                <div className="simpleMap">
                    <VehicleList />
                    <AlertsList />
                    <VinListForAlerts />
                    <VehListForMap />
                </div>
            </div>
        );
    }
}

export default App;
