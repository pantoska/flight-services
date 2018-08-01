import React, { Component } from 'react';
import axios from 'axios';
import './Repo.css';
import PositionFlight from '../Flight/PositionFlight';

class Repo extends Component {
    state = {
        flightsManager: []
    }

    componentDidMount() {
        this.getFlights();
    }

    getFlights() {
        axios.get('http://localhost:8082/api/flights')
            .then(res => {
                this.setState({
                    flightsManager: res.data
                })
            });
    }

    render() {
        return (
            <div>
                <table align="center">
                    <tbody>
                        <tr>
                            <th>Id Flight</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Latitude/Longitude</th>
                        </tr>
                        {this.state.flightsManager.map((flight) =>
                            <tr key={flight.id} className='FlightDescription'>
                                <pre>{flight.id}</pre>
                                <td>{flight.from}</td>
                                <td>{flight.to}</td>
                                <td><PositionFlight flightId={flight.id} /></td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        );
    }

}

export default Repo;