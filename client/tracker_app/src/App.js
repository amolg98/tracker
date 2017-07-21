import React, { Component } from 'react';
import './App.css';
import axios from 'axios';
import VehicleList from './Vehicle/VehicleList.js';


class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            planetList:[]
        }
    }


    componentDidMount() {
        var self = this;
        console.log('--> Triggering from XHR');
        const vehicleList = "http://swapi.co/api/planets/";
        axios.get(vehicleList)
            .then(function(response){
                console.log(response);
                if(response.data.result){
                    self.setState({
                        planetList : response.data.result
                    })
                }

            })
            .catch(function (error) {

            });
    }



    render() {
        console.log('--> Mounted in Render method');
        console.log(this.state.planetList);
        return (
            <div className="App">
                <div className="App-header">
                    <h2>Welcome to React</h2>
                </div>
                <div>
                    <VehicleList />
                </div>
            </div>
        );
    }

}

export default App;
