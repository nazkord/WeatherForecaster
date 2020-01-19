package com.nazkord;

import java.util.List;

public interface HttpCommunication {
    String getWeatherByCity(String City);
    String getParameterForCityInDate(String date, String city, String parameter);
    String getUVFromCities(List<String> cities);
}
