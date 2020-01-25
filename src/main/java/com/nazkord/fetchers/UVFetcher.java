package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;
import com.nazkord.model.Coordinates;
import com.nazkord.utils.CoordinatesUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UVFetcher extends Fetcher {

    private Map<Coordinates, String> uvForecast = new HashMap<>();
    private Map<Coordinates, String> uvHistory = new HashMap<>();

    public UVFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        List<Coordinates> coordinatesList = CoordinatesUtil.getListOfCoordinates(optionValues);
        coordinatesList.forEach(c -> {
            uvForecast.put(c, getForecast(c));
            uvHistory.put(c, getHistory(c));
        });
    }

    private String getForecast(Coordinates coordinates) {
        return OkHttpCommunication.getInstance().getUVForecastFromCoordinates(coordinates);
    }

    private String getHistory(Coordinates coordinates) {
        return OkHttpCommunication.getInstance().getUVHistoricalFromCoordinates(coordinates);
    }


}
