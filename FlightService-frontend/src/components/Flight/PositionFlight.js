import React, { Component } from 'react';
import axios from 'axios';

class PositionFlight extends Component {
    constructor(props) {
        super(props);
        this.state = {
            latitude: null,
            longitude: null,
        }
    }

    componentDidMount() {
        this.getPositionOfFlights();
    }

    getPositionOfFlights() {
        axios.get('http://localhost:8081/api/flights/' + this.props.flightId)
            .then(res => {
                this.setState({
                    latitude: res.data.latitude,
                    longitude: res.data.longitude
                })
            });
    }

    render() {
        return (
            <div>
                {this.state.longitude}
                , {this.state.latitude}</div>
        )
    }
}

export default PositionFlight;