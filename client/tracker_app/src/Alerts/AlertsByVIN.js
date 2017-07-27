import React, { Component } from 'react';
import './Alerts.css';

import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import 'react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

class AlertsByVIN extends Component {

    constructor(props) {
        super(props);
        this.state = {
            AlertsListByVin:[]
        };
    }

    componentWillReceiveProps(nextProps){
        this.setState({AlertsListByVin: nextProps.metaAlertsByVinData});
    }


    render() {
        return (
            <div className="alert-table" >
                <BootstrapTable data={ this.state.AlertsListByVin} height='300' scrollTop={ 'Bottom' } >
                    <TableHeaderColumn width='50' dataField='id' isKey={true}>Alert ID</TableHeaderColumn>
                    <TableHeaderColumn width='50' dataField='vin'>Vehicle ID Number</TableHeaderColumn>
                    <TableHeaderColumn width='200' dataField='message'>Alert Message</TableHeaderColumn>
                </BootstrapTable>
            </div>

        );
    }
}

export default AlertsByVIN;
