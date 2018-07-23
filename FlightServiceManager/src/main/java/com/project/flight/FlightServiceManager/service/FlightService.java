package com.project.flight.FlightServiceManager.service;

import com.project.flight.FlightServiceManager.entity.FlightEntity;
import com.project.flight.FlightServiceManager.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }

    public void addFlight(FlightEntity flight) {
        flightRepository.save(flight);
    }
}
