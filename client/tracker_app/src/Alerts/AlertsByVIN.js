import React, { Component } from 'react';
import './Alerts.css';

class AlertsByVIN extends Component {
    render() {
        return (
            <div className="Alerts">
                <table>
                    <tr>
                        <td>VIN : {this.props.metaAlertsData.vin}</td>
                        <td>AlertID : {this.props.metaAlertsData.id}</td>
                    </tr>
                </table>
            </div>
        );
    }
}

export default AlertsByVIN;
