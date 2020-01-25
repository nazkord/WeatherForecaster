package com.nazkord.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Coordinates {
    private String latitude;
    private String longitude;

    public Coordinates(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
