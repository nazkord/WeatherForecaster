package com.nazkord.fetchers;

import com.google.gson.Gson;
import com.nazkord.OkHttpCommunication;
import com.nazkord.model.ForecastWeather;
import com.nazkord.model.Parameter;
import com.nazkord.options.AverageOption;
import com.nazkord.parsers.AverageParser;

public class AverageFetcher extends Fetcher {

    public AverageFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        String city = AverageOption.getCity(optionValues);
        Parameter parameter = AverageOption.getParameter(optionValues);
        String jsonInString = OkHttpCommunication.getInstance().getWeatherByCity(city, OkHttpCommunication.FORECAST);
        Gson gson = new Gson();
        ForecastWeather forecastWeather = gson.fromJson(jsonInString, ForecastWeather.class);
        AverageOption.draw(optionValues, AverageParser.parse(forecastWeather, parameter));
    }
}
