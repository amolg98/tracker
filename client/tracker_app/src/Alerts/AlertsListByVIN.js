import React, { Component } from 'react';
import './AlertsList.css';
import AlertsByVIN from "./AlertsByVIN";

class AlertsListByVIN extends Component {

    constructor(props) {
        super(props);
        this.state = {
            AlertsListData:[]
        };
    }

    componentWillReceiveProps(nextProps){
        console.log('Inside '+ this.props.nameD);
        this.setState({AlertsListData: nextProps.nameD});
        console.log("In method just before ");
    }


    render() {
        let AlertsListData;

        if(this.state.AlertsListData){
            AlertsListData = this.state.AlertsListData.map(AlertsData => {
                return(
                    <AlertsByVIN key={AlertsData.id} metaAlertsData={AlertsData} />
                );
            })
        }

        console.log('Inside Alerts list render method '+ AlertsListData);
        return (
            <div className="AlertsList">
                {AlertsListData}
            </div>
        );
    }
}

export default AlertsListByVIN;