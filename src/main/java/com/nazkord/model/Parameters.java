package com.nazkord.model;

public enum Parameters {
    TEMP,
    PRESSURE,
    HUMIDITY,
    WIND_SPEED,
    CLOUDINESS;

    public static String getParameter(CurrentWeather currentWeather, Parameters parameter) {
        switch (parameter) {
            case TEMP: return String.valueOf(currentWeather.getMain().getTemp());
            case PRESSURE: return String.valueOf(currentWeather.getMain().getPressure());
            case HUMIDITY: return String.valueOf(currentWeather.getMain().getHumidity());
            case WIND_SPEED: return String.valueOf(currentWeather.getWind().getSpeed());
            case CLOUDINESS: return String.valueOf(currentWeather.getClouds().getAll());
            //TODO: throw exception
            default: {
                return "Bad parameter";
            }
        }
    }
}
