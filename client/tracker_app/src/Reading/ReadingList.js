import React, { Component } from 'react';
import Reading from './Reading.js';
import axios from 'axios';
import './ReadingList.css';

class ReadingList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            ReadingList:[]
        };
    }

    componentDidMount() {
        var self = this;
        console.log('--> Triggering from XHR');
        const ReadingListURL = "http://localhost:8080/readings";
        axios.get(ReadingListURL)
            .then(function(response){
                //console.log(response);
                if(response.data){
                    self.setState({
                        ReadingList : response.data
                    })
                }
            })
            .catch(function (error) {

            });
    }



    render() {
        let ReadingListData;

        if(this.state.ReadingList){
            ReadingListData = this.state.ReadingList.map(ReadingData => {
                return(
                    <Reading metaReadingData={ReadingData} />
                );
            })
        }

        //console.log('Inside Reading list render method '+ ReadingListData);
        return (
            <div className="ReadingList">
                {ReadingListData}
            </div>
        );
    }
}

export default ReadingList;