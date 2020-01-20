package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;

public class AverageFetcher extends Fetcher {

    public AverageFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(optionValues[0], OkHttpCommunication.FORECAST));
    }
}
