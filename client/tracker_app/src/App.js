import React, { Component } from 'react';
import './App.css';
import VehicleList from './Vehicle/VehicleList.js';
import ReadingList from "./Reading/ReadingList";


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
                    <ReadingList />
                </div>
            </div>
        );
    }

}

export default App;