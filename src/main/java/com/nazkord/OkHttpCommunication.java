package com.nazkord;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OkHttpCommunication implements HttpCommunication {

    private static final String URL = "https://api.openweathermap.org/data/2.5";
    private static final String Weather = "/weather";
    private static final String Forecast = "/forecast";
    private static final String UV = "/uvi";
    private static final String APIKey = "8930138d8ad840392f3e01aa2ef43c58";

    @Override
    public String getWeatherByCity(String City) {
        return null;
    }

    @Override
    public String getParameterForCityInDate(String date, String city, String parameter) {
        return null;
    }

    @Override
    public String getUVFromCities(List<String> cities) {
        return null;
    }
}
