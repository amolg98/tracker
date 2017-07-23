import React, { Component } from 'react';
import { withGoogleMap, GoogleMap, Marker } from 'react-google-map';

class Map extends Component {

    render() {

        const markers = this.props.marker || [];
        return(
          <div>
              <GoogleMap
                  defaultZoom={3}
                  defaultCenter={{ lat: -25.363882, lng: 131.044922 }} >
                  {markers.map((marker, index) => (
                            <Marker {...marker} />
                        )
                  )}
              </GoogleMap>
          </div>
        );
    }
}

export default withGoogleMap(Map);