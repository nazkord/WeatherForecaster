package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;

public class CityFetcher extends Fetcher {

    public CityFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(optionValues[0], OkHttpCommunication.WEATHER));
    }
}
