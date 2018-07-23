package com.project.flight.FlightServiceManager.repository;

import com.project.flight.FlightServiceManager.entity.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<FlightEntity, String> {
}
