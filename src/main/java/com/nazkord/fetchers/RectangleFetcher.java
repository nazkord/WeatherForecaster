package com.nazkord.fetchers;

import com.google.gson.Gson;
import com.nazkord.OkHttpCommunication;
import com.nazkord.model.BoxWeather;
import com.nazkord.model.Parameter;
import com.nazkord.options.RectangleZoneOption;
import com.nazkord.parsers.RectangleZoneParser;
import com.nazkord.utils.CoordinatesUtil;

import java.util.Arrays;

public class RectangleFetcher extends Fetcher {
    public RectangleFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        Parameter parameter = RectangleZoneOption.getParameter(optionValues);
        String jsonInString = OkHttpCommunication.getInstance().getRectangleZone(CoordinatesUtil.getBoxCoordinatesFromArguments(optionValues));
        Gson gson = new Gson();
        BoxWeather boxWeather = gson.fromJson(jsonInString, BoxWeather.class);
        System.out.println(RectangleZoneParser.parse(boxWeather.getList(), parameter));
    }
}
