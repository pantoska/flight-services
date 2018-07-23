package com.project.flight.FlightServiceEmulator.controller;

import com.project.flight.FlightServiceEmulator.model.PositionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class Task implements Runnable{

    private final String id;
    private final RestTemplate restTemplate;
    private static final Random r = new Random();
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public Task(String id, RestTemplate restTemplate) {
        this.id = id;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {
        PositionDto request = updatePosition();
        logger.debug(request.toString());
    }

    private PositionDto updatePosition() {
        PositionDto positionDto = new PositionDto();
        positionDto.setLatitude(r.nextInt());
        positionDto.setLongitude(r.nextInt());
        return positionDto;
    }

    public String getId() {
        return id;
    }
}
