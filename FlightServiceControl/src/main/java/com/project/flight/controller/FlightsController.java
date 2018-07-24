package com.project.flight.controller;

import com.project.flight.entity.FlightEntity;
import com.project.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FlightsController {

    private FlightService flightService;

    @Autowired
    public FlightsController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FlightEntity> getFlight(@PathVariable String id) {
        return flightService.getFlight(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFlight(@RequestBody FlightEntity flight) {
        flightService.updateFlight(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFlight(@RequestBody FlightEntity flight) {
        flightService.saveFlight(flight);
    }

}
