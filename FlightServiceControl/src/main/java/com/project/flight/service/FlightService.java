package com.project.flight.service;

import com.project.flight.entity.FlightEntity;
import com.project.flight.error.InternalServerErrorException;
import com.project.flight.repositor.FlightRepository;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Optional<FlightEntity> getFlight(String id) {
        return flightRepository.findById(id);
    }

    public void updateFlight(FlightEntity flight) {
        //TODO Service Manager przechowywuje id lotow, ty powinnas tutaj z kim sie komunikowac i sprawdzic
        //TODO czy istnieje w jego bazie taki lot jesli tak to update, jesli nie to zwraca taki status
        //TODO zeby Service Emulator nie robil update lotow o tej id
        //TODO wazne: musisz znac PORT flightServiceManager
        flightRepository.save(flight);
    }


    public void deleteFlight(@PathVariable String id) {
        flightRepository.deleteById(id);
    }

}