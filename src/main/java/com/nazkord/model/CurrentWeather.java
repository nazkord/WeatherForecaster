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
    private Wind wind;
    private Clouds clouds;
    private float dt;
    private String dt_txt;
    private float id;
    private String name;
    private float cod;
}