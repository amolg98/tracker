import React, { Component } from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import './Alerts.css';

class AlertsByVIN extends Component {
    render() {
        return (
            <BootstrapTable data={ this.props.metaAlertsData }>
                <TableHeaderColumn dataField='vin' isKey>Vehicle ID</TableHeaderColumn>
                <TableHeaderColumn dataField='id'>Alert ID</TableHeaderColumn>
            </BootstrapTable>
        );
    }
}

export default AlertsByVIN;
