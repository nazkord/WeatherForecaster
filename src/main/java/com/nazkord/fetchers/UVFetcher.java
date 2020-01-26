package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;
import com.nazkord.model.Coordinates;
import com.nazkord.options.UVOption;
import com.nazkord.parsers.UVParser;
import com.nazkord.utils.CoordinatesUtil;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UVFetcher extends Fetcher {

    private Map<Coordinates, Pair<Float, Float>> uvValuesMap = new HashMap<>();

    public UVFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        List<Coordinates> coordinatesList = CoordinatesUtil.getListOfCoordinates(optionValues);
        coordinatesList.forEach(c -> uvValuesMap.put(c, UVParser.parse(getForecast(c), getHistory(c))));
        UVOption.draw(uvValuesMap);
    }

    private String getForecast(Coordinates coordinates) {
        return OkHttpCommunication.getInstance().getUVForecastFromCoordinates(coordinates);
    }

    private String getHistory(Coordinates coordinates) {
        return OkHttpCommunication.getInstance().getUVHistoricalFromCoordinates(coordinates);
    }


}
