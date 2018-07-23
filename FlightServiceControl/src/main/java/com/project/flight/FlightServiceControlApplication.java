package com.project.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.project.flight.Flights"})
public class FlightServiceControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceControlApplication.class, args);
    }
}
