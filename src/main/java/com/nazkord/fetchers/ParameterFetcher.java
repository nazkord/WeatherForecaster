package com.nazkord.fetchers;

import com.google.gson.Gson;
import com.nazkord.OkHttpCommunication;
import com.nazkord.model.ForecastWeather;
import com.nazkord.options.ParameterOption;
import com.nazkord.parsers.ParameterParser;

public class ParameterFetcher extends Fetcher {

    public ParameterFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        //TODO: handling bad data
        String city = ParameterOption.getCity(optionValues);
        String jsonInString = OkHttpCommunication.getInstance().getWeatherByCity(city, OkHttpCommunication.FORECAST);
        Gson gson = new Gson();
        ForecastWeather forecastWeather = gson.fromJson(jsonInString, ForecastWeather.class);
        ParameterOption.draw(optionValues, ParameterParser.parse(forecastWeather, optionValues));
    }
}
