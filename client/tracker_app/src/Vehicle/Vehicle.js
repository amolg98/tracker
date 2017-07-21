import React, { Component } from 'react';
import './Vehicle.css';

class Vehicle extends Component {
    render() {
        return (
            <div className="Vehicle">
                <table>
                    <tr>
                        <td>Vehicle ID : {this.props.metaVehicleData.vin}</td>
                        <td>Vehicle Make : {this.props.metaVehicleData.make}</td>
                        <td>Vehicle Model : {this.props.metaVehicleData.model}</td>
                        <td>Vehicle Year : {this.props.metaVehicleData.year}</td>
                        <td>Vehicle Red Line RPM : {this.props.metaVehicleData.redlineRpm}</td>
                        <td>Vehicle Max Fuel Volume : {this.props.metaVehicleData.maxFuelVolume}</td>
                        <td>Vehicle Last Service Date : {this.props.metaVehicleData.lastServiceDate}</td>
                    </tr>
                </table>
            </div>
        );
    }
}

export default Vehicle;
