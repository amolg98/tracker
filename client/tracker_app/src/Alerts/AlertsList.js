import React, { Component } from 'react';
import Alerts from './Alerts.js';
import axios from 'axios';
import './AlertsList.css';

class AlertsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            AlertsList:[]
        };
    }


    componentDidMount() {
        var self = this;
        console.log('--> Triggering from XHR');
        //const AlertsListURL = "http://swapi.co/api/planets/";
        const AlertsListURL = "http://localhost:8080/alerts/highAlert";
        axios.get(AlertsListURL)
            .then(function(response){
                console.log(response);
                if(response.data){
                    self.setState({
                        AlertsList : response.data
                    })
                }
            })
            .catch(function (error) {

            });
    }


    render() {
        //let AlertsListData;

        if(this.state.AlertsList){
            return(
                <div>
                    <Alerts metaAlertsData={this.state.AlertsList} />
                </div>
            );
        }

        return (
            <div className="AlertsList">
                {this.state.AlertsList}
            </div>
        );
    }
}

export default AlertsList;