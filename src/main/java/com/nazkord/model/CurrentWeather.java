package com.nazkord.model;

import lombok.Data;

import java.util.List;

@Data
public class CurrentWeather {
    private Coordinates coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private float visibility;
    Wind wind;
    Clouds clouds;
    private float dt;
    private float id;
    private String name;
    private float cod;
}