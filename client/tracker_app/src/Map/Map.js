import React, { Component } from "react";
import { withGoogleMap, GoogleMap, Marker } from "react-google-maps";

class Map extends Component {

    constructor(){
        super();
        this.state = {
            map:null,
            mapData:[]
        }
    }

    componentWillReceiveProps(nextProps){
        console.log('Inside Map component ');
        console.log(nextProps.markers);
        this.setState({mapData: nextProps.markers});
        console.log("In method just before this part ");
    }

    mapMoved(){
        // console.log('mapMoved: '+ JSON.stringify(this.state.map.getCenter()))
    }

    zoomChanged(){
        // console.log('zoomChanged: '+this.state.map.getZoom())
    }

    mapLoaded(map){
        // console.log('mapLoaded: ' + JSON.stringify(map.getCenter()))
        if(this.state.map !== null)
            return;

        this.setState({
            map: map
        })
    }

    render() {
        console.log("In Map render method ");
        //console.log(this.state.mapData);
        var markers = this.props.markers.map((venue, index) => {
            const marker = {
                position: {
                    lat: venue.latitude,
                    lng: venue.longitude
                }
            };


            return <Marker key={index} { ...marker } />
        });

        return (
            <GoogleMap
                ref={this.mapLoaded.bind(this)}
                onDragEnd={this.mapMoved.bind(this)}
                onZoomChanged={this.zoomChanged.bind(this)}
                defaultZoom={this.props.zoom}
                defaultCenter={this.props.center} >
                { markers }
            </GoogleMap>

        );
    }
}

export default withGoogleMap(Map);
