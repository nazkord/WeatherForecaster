package com.nazkord.fetchers;

import com.google.gson.Gson;
import com.nazkord.OkHttpCommunication;
import com.nazkord.model.CurrentWeather;
import com.nazkord.model.Wind;

public class CityFetcher extends Fetcher {

    public CityFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        String jsonInString = OkHttpCommunication.getInstance().getWeatherByCity(optionValues[0], OkHttpCommunication.WEATHER);
        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(jsonInString, CurrentWeather.class);
    }
}
