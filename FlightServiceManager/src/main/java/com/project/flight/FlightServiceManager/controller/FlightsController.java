package com.project.flight.FlightServiceManager.controller;

import com.project.flight.FlightServiceManager.entity.FlightEntity;
import com.project.flight.FlightServiceManager.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FlightsController {

    private FlightService flightService;

    @Autowired
    public FlightsController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method= RequestMethod.GET, value = "/flights")
    @ResponseStatus(HttpStatus.OK)
    public List<FlightEntity> getAllFlights() {
        return flightService.getAllFlights();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFlight(@RequestBody FlightEntity flight) {
        flightService.addFlight(flight);
    }

}
