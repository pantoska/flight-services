package com.project.flight.FlightServiceEmulator.entity;

public class FlightEntity {
    private int latitude;
    private int longitude;

    public FlightEntity() {
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int x) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int y) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PositionDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
