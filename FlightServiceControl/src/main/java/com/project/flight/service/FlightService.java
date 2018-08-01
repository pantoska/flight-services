package com.project.flight.service;

import com.project.flight.dto.FlightControllerDto;
import com.project.flight.entity.FlightEntity;
import com.project.flight.error.NotFoundException;
import com.project.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FlightService {

    private RestTemplate restTemplate = new RestTemplate();
    private FlightRepository flightRepository;
    private final HttpHeaders headers = new HttpHeaders();
    private static final String POSITION_URI = "http://127.0.0.1:8082/api/flights/";

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
        headers.setContentType(MediaType.APPLICATION_JSON);
        FlightControllerDto flightControllerDto = new FlightControllerDto(id);
        HttpEntity<FlightControllerDto> entity = new HttpEntity<>(flightControllerDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(POSITION_URI + id, HttpMethod.DELETE, entity, String.class);
    }

    public void saveFlight(FlightEntity flight) {
        flightRepository.save(flight);
    }

}
