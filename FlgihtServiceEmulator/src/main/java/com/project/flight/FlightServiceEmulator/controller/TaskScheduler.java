package com.project.flight.FlightServiceEmulator.controller;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskScheduler {
    private ScheduledExecutorService scheduler;
    private Map<String, Task> tasks;
    private final RestTemplate restTemplate;
    private final static Logger log = LoggerFactory.getLogger(TaskScheduler.class);

    public TaskScheduler(RestTemplate restTemplate) {
        this.scheduler = Executors.newScheduledThreadPool(5);
        this.tasks = new TreeMap<>();
        this.restTemplate = restTemplate;
    }

    public void addTask(String id) {
        Task task = new Task(id, restTemplate);
        tasks.put(id, task);
    }

    public void stopTask(String id) {
        tasks.remove(id);
    }

    @Scheduled(fixedRate = 1500)
    public void update() {
        for(Task task : tasks.values()) {
            ScheduledFuture<?> result = scheduler.schedule(task, 2, TimeUnit.SECONDS);
            try {
                if(result.get() != HttpStatus.OK) {
                    stopTask(task.getId());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }



}

