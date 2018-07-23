package com.project.flight.FlightServiceEmulator.model;

public class PositionDto {
    private int latitude;
    private int longitude;

    public PositionDto() {
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

}