package com.project.flight.service;

import com.project.flight.entity.FlightEntity;
import com.project.flight.error.NotFoundException;
import com.project.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightEntity getFlight(String id) {
        return flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity with id:" + id + "not exists."));
    }

    public void updateFlight(FlightEntity flight) {
        flightRepository.findById(flight.getId()).orElseThrow(() -> new NotFoundException("Not found ID"));
        flightRepository.save(flight);
    }

    public void deleteFlight(@PathVariable String id) {
        flightRepository.deleteById(id);
    }

    public void saveFlight(FlightEntity flight) {
        flightRepository.save(flight);
    }

}
