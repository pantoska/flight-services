package com.project.flight.FlightServiceEmulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class EmulatorController {
    private final TaskScheduler scheduledEmulator;
    private final RestTemplate restTemplate;

    @Autowired
    public EmulatorController(TaskScheduler scheduledEmulator, RestTemplate restTemplate) {
        this.scheduledEmulator = scheduledEmulator;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public void startFlight(@PathVariable("id") String id) {
        scheduledEmulator.addTask(id);
    }

    @RequestMapping(value = "/{id}/stop", method = RequestMethod.POST)
    public void stopFlight(@PathVariable("id") String id) {
        scheduledEmulator.stopTask(id);
    }
}
