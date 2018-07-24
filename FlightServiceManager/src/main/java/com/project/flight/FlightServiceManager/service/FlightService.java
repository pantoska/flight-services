package com.project.flight.FlightServiceManager.service;

import com.project.flight.FlightServiceManager.dto.FlightControllerDto;
import com.project.flight.FlightServiceManager.dto.FlightDto;
import com.project.flight.FlightServiceManager.entity.FlightEntity;
import com.project.flight.FlightServiceManager.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class FlightService {

    private RestTemplate restTemplate;
    private FlightRepository flightRepository;
    private final HttpHeaders headers = new HttpHeaders();
    private static final String POSITION_URI = "http://127.0.0.1:8081/api/flights/";

    @Autowired
    public FlightService(FlightRepository flightRepository, RestTemplate restTemplate) {
        this.flightRepository = flightRepository;
        this.restTemplate = restTemplate;
    }

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findAll();
    }

    public void addFlight(FlightEntity flight) {
        flightRepository.save(flight);
        headers.setContentType(MediaType.APPLICATION_JSON);
        FlightControllerDto flightControllerDto = new FlightControllerDto(flight.getId());
        HttpEntity<FlightControllerDto> entity = new HttpEntity<>(flightControllerDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(POSITION_URI, HttpMethod.POST, entity, String.class);
    }
}
