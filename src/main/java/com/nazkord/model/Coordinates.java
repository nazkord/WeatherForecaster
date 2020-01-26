package com.nazkord.model;

import lombok.Data;

@Data
public class Coordinates {
    private String lat;
    private String lon;

    public Coordinates(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
