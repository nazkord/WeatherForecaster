package com.nazkord.model;

import lombok.Data;

@Data
public class UVWeather {
    private float lat;
    private float lon;
    private String date_iso;
    private Integer date;
    private Float value;
}
