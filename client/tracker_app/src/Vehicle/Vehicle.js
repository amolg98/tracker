import React, { Component } from 'react';
import './Vehicle.css';

import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import 'react-bootstrap-table/dist/react-bootstrap-table-all.min.css';


class Vehicle extends Component {

    constructor(props) {
        super(props);
        this.state = {
            vehicleList:[]
        };
    }

    componentWillReceiveProps(nextProps){
        this.setState({vehicleList: nextProps.metaData});
    }


    render() {
        return (
            <div className="vehicle-table" >
                <h2>Vehicle Data</h2>
                <BootstrapTable data={ this.state.vehicleList } height='300' scrollTop={ 'Bottom' } >
                    <TableHeaderColumn width='60' dataField='vin' isKey>Vehicle ID Number</TableHeaderColumn>
                    <TableHeaderColumn width='50' dataField='make'>Make</TableHeaderColumn>
                    <TableHeaderColumn width='50' dataField='model'>Model</TableHeaderColumn>
                    <TableHeaderColumn width='30' dataField='year'>Year</TableHeaderColumn>
                    <TableHeaderColumn width='70' dataField='redlineRpm'>Red Line RPM</TableHeaderColumn>
                    <TableHeaderColumn width='70' dataField='maxFuelVolume'>Max Fuel Volume</TableHeaderColumn>
                    <TableHeaderColumn width='150' dataField='lastServiceDate'>Last Service Date</TableHeaderColumn>
                </BootstrapTable>
            </div>
        );
    }
}

export default Vehicle;
