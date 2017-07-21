import React, { Component } from 'react';
import './Alerts.css';

class Alerts extends Component {
    render() {
        return (
            <div className="Alerts">
                <table>
                    <tr>
                        <td>ID : {this.props.metaAlertsData.id}</td>
                        <td>Priority : {this.props.metaAlertsData.priority}</td>
                        <td>Reading ID : {this.props.metaAlertsData.model}</td>
                        <td>VIN : {this.props.metaAlertsData.year}</td>
                    </tr>
                </table>
            </div>
        );
    }
}

export default Alerts;
