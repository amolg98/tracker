import React, { Component } from 'react';
import './Reading.css';

class Reading extends Component {
    render() {
        return (
            <div className="Reading">
                <h2>Vehicle ID : {this.props.metaReadingData.vin}</h2>
            </div>
        );
    }
}

export default Reading;
