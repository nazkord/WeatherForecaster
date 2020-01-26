package com.nazkord.model;

import lombok.Data;

import java.util.List;

@Data
public class ForecastWeather {
    private List<CurrentWeather> list;
    private City city;

    public ForecastWeather(City city, List<CurrentWeather> list) {
        this.city = city;
        this.list = list;
    }
}
