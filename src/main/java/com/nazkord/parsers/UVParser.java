package com.nazkord.parsers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nazkord.model.UVWeather;
import javafx.util.Pair;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UVParser {

    public static Pair<Float, Float> parse(String forecastInString, String historyInString) {
        List<UVWeather> forecastUVList = getUVList(forecastInString);
        List<UVWeather> historyUVList = getUVList(historyInString);
        List<Float> uvValues = unionOf(forecastUVList, historyUVList);
        return new Pair<>(Collections.min(uvValues), Collections.max(uvValues));
    }

    private static List<UVWeather> getUVList(String jsonInString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<UVWeather>>(){}.getType();
        return gson.fromJson(jsonInString, collectionType);
    }

    private static List<Float> unionOf(List<UVWeather> forecast, List<UVWeather> history) {
        List<Float> uvValues = forecast.stream()
                .map(UVWeather::getValue).collect(Collectors.toList());
        uvValues.addAll(
                history.stream()
                        .map(UVWeather::getValue)
                        .collect(Collectors.toList())
        );
        return uvValues;
    }
}
