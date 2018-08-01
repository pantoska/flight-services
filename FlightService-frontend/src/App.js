import React, { Component } from 'react';
import Flight from './components/Flight/Flight';
import FlightDelete from './components/Flight/FlightDelete';
import Header from './components/Home/Header';
import Home from './components/Home/Home';
import Navigation from './components/Navigation';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      
      <BrowserRouter>
        <div>
          <Header />
          <Navigation />
          <Switch>
            <Route path="/" component={Home} exact />
            <Route path="/flightAdd" component={Flight} />
            <Route path="/flightDelete" component={FlightDelete} />
          </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;