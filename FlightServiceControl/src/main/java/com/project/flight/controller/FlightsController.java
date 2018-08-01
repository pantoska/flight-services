package com.project.flight.controller;

import com.project.flight.dto.FlightDto;
import com.project.flight.entity.FlightEntity;
import com.project.flight.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FlightsController {

    private FlightService flightService;
    private ModelMapper modelMapper;

    @Autowired
    public FlightsController(FlightService flightService, ModelMapper modelMapper) {
        this.flightService = flightService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FlightEntity getFlight(@PathVariable String id) {
        return flightService.getFlight(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFlight(@PathVariable String id, @RequestBody FlightDto flight) {
        System.out.println(flight.toString());
        FlightEntity entity = convertToEntity(flight);
        entity.setId(id);
        flightService.updateFlight(entity);
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

    private FlightEntity convertToEntity(FlightDto flightDto){
        FlightEntity entity = modelMapper.map(flightDto, FlightEntity.class);
        return entity;
    }

}
