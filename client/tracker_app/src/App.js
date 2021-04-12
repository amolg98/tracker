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
                <div className="App-body">
                    <div className="vehicle-list">
                        <VehicleList />
                    </div>
                    <div className="alertsByVin-list">
                        <VinListForAlerts />
                    </div>

                    <div className="alert-list">
                        <AlertsList />
                    </div>
                    <div className="simpleMap">
                        <VehListForMap />
                    </div>
                    <div className="footer">
                        <footer>
                            &copy; 1930 Website &nbsp;<span class="separator">|</span> Design by Amol Gupta
                        </footer>
                    </div>
                </div>

            </div>
        );
    }
}

export default App;
