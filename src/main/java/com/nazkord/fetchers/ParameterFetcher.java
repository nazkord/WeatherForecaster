package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;

public class ParameterFetcher extends Fetcher {

    public ParameterFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(optionValues[1], OkHttpCommunication.FORECAST));
    }
}
