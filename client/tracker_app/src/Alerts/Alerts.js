import React, { Component } from 'react';
import './Alerts.css';

import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import 'react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

class Alerts extends Component {
    render() {
        return (
            <div className="alert-table" >
                <h2>Vehicle Alert Count</h2>
                <BootstrapTable data={ this.props.metaAlertsData} height='300' scrollTop={ 'Bottom' } >
                    <TableHeaderColumn width='100' dataField='vin' isKey>Vehicle ID Number</TableHeaderColumn>
                    <TableHeaderColumn width='100' dataField='count'>Alert Count</TableHeaderColumn>
                </BootstrapTable>
            </div>
        );
    }
}

export default Alerts;
