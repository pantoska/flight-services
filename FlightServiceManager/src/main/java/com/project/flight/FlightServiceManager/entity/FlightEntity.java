package com.project.flight.FlightServiceManager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlightInformation")
public class FlightEntity {
    @Id
    private String id;
    private String from;
    private String to;

    public FlightEntity() {
    }

    public FlightEntity(String id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to= to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
