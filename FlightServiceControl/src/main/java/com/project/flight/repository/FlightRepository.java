package com.project.flight.repository;

import com.project.flight.entity.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<FlightEntity, String> {
}
