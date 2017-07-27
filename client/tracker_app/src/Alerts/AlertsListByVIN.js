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
        //let AlertsListData;

        if(this.state.AlertsListData){
            return(
                <div>

                    <AlertsByVIN metaAlertsByVinData={this.state.AlertsListData} />
                </div>
                );
        }

        return (
            <div className="AlertsList">
                {this.state.AlertsListData}
            </div>
        );
    }
}

export default AlertsListByVIN;