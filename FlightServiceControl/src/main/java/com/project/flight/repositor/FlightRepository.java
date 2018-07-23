package com.project.flight.repositor;

import com.project.flight.entity.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<FlightEntity, String> {
}
