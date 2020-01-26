package com.nazkord.fetchers;

import com.google.gson.Gson;
import com.nazkord.OkHttpCommunication;
import com.nazkord.model.ForecastWeather;

public class ParameterFetcher extends Fetcher {

    public ParameterFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        //TODO: handling bad data
        String date = optionValues[0];
        int hour = (Integer.parseInt(optionValues[1]));
        if(!(hour >=0 && hour <= 24)) hour = -1;
        String parameter = optionValues[3];
        String jsonInString = OkHttpCommunication.getInstance().getWeatherByCity(optionValues[2], OkHttpCommunication.FORECAST);
        Gson gson = new Gson();
        ForecastWeather forecastWeather = gson.fromJson(jsonInString, ForecastWeather.class);
        System.out.println(forecastWeather.getCity().getName());
    }
}
