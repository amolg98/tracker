import React, { Component } from 'react';
import './App.css';
import VehicleList from './Vehicle/VehicleList.js';
//import ReadingList from "./Reading/ReadingList";
import AlertsList from "./Alerts/AlertsList.js";
//import Map  from "./Map/map.js";


class App extends Component {

    render() {
        console.log('--> Mounted in Render method');
        return (
            <div className="App">
                <div className="App-header">
                    <h2>Welcome to React</h2>
                </div>
                <div>
                    <VehicleList />
                    <AlertsList />
                    {/*<Map*/}
                        {/*containerElement={<div style={{height:100+'%'}} />}*/}
                        {/*mapElement={<div style={{height:100+'%'}} />}*/}
                    {/*/>*/}
                </div>
            </div>
        );
    }

}

export default App;
