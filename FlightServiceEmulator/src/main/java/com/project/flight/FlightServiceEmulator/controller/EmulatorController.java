package com.project.flight.FlightServiceEmulator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/api/flights")
public class EmulatorController {
    private final TaskScheduler scheduledEmulator;
    private final RestTemplate restTemplate;

    @Autowired
    public EmulatorController(TaskScheduler scheduledEmulator, RestTemplate restTemplate) {
        this.scheduledEmulator = scheduledEmulator;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void startFlight(@PathVariable("id") String id) {
        scheduledEmulator.addTask(id);
    }

    @RequestMapping(value = "/{id}/stop", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void stopFlight(@PathVariable("id") String id) {
        scheduledEmulator.stopTask(id);
    }
}
