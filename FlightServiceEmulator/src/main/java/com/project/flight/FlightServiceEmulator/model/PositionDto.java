package com.project.flight.FlightServiceEmulator.model;

public class PositionDto {

    private float latitude;
    private float longitude;


    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public PositionDto(){
    }

}