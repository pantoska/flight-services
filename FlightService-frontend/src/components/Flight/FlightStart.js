import React, { Component } from 'react';
import axios from 'axios';
import './Flight.css';

class FlightStart extends Component {
    state = {
        id: '',
    }

    handleChange = event => {
        console.log("handleChange", event.target.value)
        this.setState({ id: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();
        console.log("handleSubmit", this.state.id)
        axios.post('http://localhost:8083/api/flights/' + this.state.id + '/start')
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        return (
            <div>
                <h1>Start flight:</h1>
                <p>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Flight Id:
                        <input type="text" id="id" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Start</button>
                </form>
                </p>
            </div>
        )
    }

}

export default FlightStart