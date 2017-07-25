import React, { Component } from 'react';

import VehicleList from './Vehicle/VehicleList.js';
//import ReadingList from "./Reading/ReadingList";
import AlertsList from "./Alerts/AlertsList.js";
import AlertsListByVIN from "./Alerts/AlertsListByVIN.js";
import Map from "./Map/Map";

import './App.css';
import VinListForAlerts from "./Alerts/VinListForAlerts";


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
                    <AlertsListByVIN />
                    <AlertsList />
                    <VinListForAlerts />
                    <Map center={{ lat: 29.617124, lng: -82.373750 }}
                         zoom={14}
                         containerElement={
                             <div style={{ height: `100%`, width:`100%` }} />
                         }
                         mapElement={
                             <div style={{ height: `100%`, width:`100%` }} />
                         }
                    />
                </div>
            </div>
        );
    }

}

export default App;
