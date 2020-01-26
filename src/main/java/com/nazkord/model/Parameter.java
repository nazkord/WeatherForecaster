package com.nazkord.model;

import java.util.function.Function;

public enum Parameter {
    TEMP("Temperature"),
    PRESSURE("Pressure"),
    HUMIDITY("Humidity"),
    WIND_SPEED("Speed of wind"),
    CLOUDINESS("Cloudiness");

    private String name;

    public static Float getParameter(CurrentWeather currentWeather, Parameter parameter) {
        switch (parameter) {
            case TEMP: return currentWeather.getMain().getTemp();
            case HUMIDITY: return currentWeather.getMain().getHumidity();
            case PRESSURE: return currentWeather.getMain().getPressure();
            case WIND_SPEED: return currentWeather.getWind().getSpeed();
            case CLOUDINESS: return currentWeather.getClouds().getAll();
            //TODO: throw exception
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
