import React, { Component } from 'react';
import axios from 'axios';
import './Flight.css'

export default class FlightDelete extends Component {
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
        axios.delete('http://localhost:8081/api/flights/' + this.state.id)
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
                <h1>Delete flight:</h1>
                <p>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Flight Id:
                        <input type="text" id="id" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Delete</button>
                </form>
                </p>
            </div>
        )
    }
}
