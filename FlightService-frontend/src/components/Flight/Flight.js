import React, { Component } from 'react';
import axios from 'axios';
import './Flight.css';

class Flight extends Component {
  constructor() {
    super();
    this.state = {
      id: '',
      from: '',
      to: ''
    };
  }

  handleIdChange = event => {
    console.log("handleIdChange", event.target.value)
    this.setState({ id: event.target.value });
  }

  handleFromChange = event => {
    console.log("handleFromChange", event.target.value);
    this.setState({ from: event.target.value });
  }

  handleToChange = event => {
    console.log("handleToChange", event.target.value);
    this.setState({ to: event.target.value });
  }

  handleSubmitAdd = event => {
    event.preventDefault();
    console.log("handleSubmitAdd", this.state.id, this.state.from, this.state.to);
    const flight = {
      id: this.state.id,
      from: this.state.from,
      to: this.state.to,
    };
    console.log("Flight", flight);
    axios
      .post('http://localhost:8082/api/flights', { id: this.state.id, from: this.state.from, to: this.state.to })
      .then(res => {
        console.log(res);
        console.log("res.data", res.data);
      })
      .catch(error => {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <h1>Add flight:</h1>
        <p>
          <form onSubmit={this.handleSubmitAdd.bind(this)}>
            <label>
              Flight Id:
            <input type="text" id="id" placeholder='Enter id' onChange={this.handleIdChange.bind(this)} value={this.state.id} />
            </label>
            <label>
              Flight from:
            <input type='text' from="from" placeholder='Enter from' onChange={this.handleFromChange.bind(this)} value={this.state.from} />
            </label>
            <label>
              Flight to:
            <input type="text" to="to" placeholder='Enter to' onChange={this.handleToChange.bind(this)} value={this.state.to} />
            </label>
            <button onClick={this.handleSubmitAdd}>Add</button>
          </form>
        </p>
      </div>
    );
  }
}

export default Flight

