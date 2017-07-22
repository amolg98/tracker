import React, { Component } from 'react';
import './Alerts.css';

class Alerts extends Component {
    render() {
        return (
            <div className="Alerts">
                <table>
                    <tr>
                        <td>VIN : {this.props.metaAlertsData.vin}</td>
                        <td>Count : {this.props.metaAlertsData.count}</td>
                    </tr>
                </table>
            </div>
        );
    }
}

export default Alerts;
