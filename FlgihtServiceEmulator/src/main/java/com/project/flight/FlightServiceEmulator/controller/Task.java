package com.project.flight.FlightServiceEmulator.controller;

import com.project.flight.FlightServiceEmulator.model.PositionDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class Task implements Runnable{

    private final String id;
    private final RestTemplate restTemplate;
    private static final Random r = new Random();
    private static final String POSITION_URI = "http://127.0.0.1:8081/api/flights/";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final HttpHeaders headers = new HttpHeaders();
    private ResponseEntity<String> response;


    public Task(String id, RestTemplate restTemplate) {
        this.id = id;
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);

    }

    @Override
    public void run() {
        PositionDto request = updatePosition();
        logger.debug(request.toString());
        HttpEntity<PositionDto> entity = new HttpEntity<>(request, headers);
        try {
            response = restTemplate.exchange(POSITION_URI + id, HttpMethod.PUT, entity, String.class);
        } catch (ResourceAccessException e) {
            logger.debug(e.getMessage());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.debug(e.getMessage());
        }
        logger.debug(response.toString());
    }

    private PositionDto updatePosition() {
        PositionDto positionDto = new PositionDto();
        positionDto.setLatitude(r.nextFloat());
        positionDto.setLongitude(r.nextFloat());
        return positionDto;
    }

    public String getId() {
        return id;
    }
}
