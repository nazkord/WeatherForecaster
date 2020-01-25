package com.nazkord.fetchers;

import com.nazkord.OkHttpCommunication;
import com.nazkord.utils.CoordinatesUtil;

import java.util.Arrays;

public class RectangleFetcher extends Fetcher {
    public RectangleFetcher(String fetcherOption) {
        super(fetcherOption);
    }

    @Override
    public void fetch(String[] optionValues) {
        System.out.println(Arrays.toString(optionValues));
        String parameter = optionValues[optionValues.length - 1];
        System.out.println(OkHttpCommunication.getInstance().getRectangleZone(CoordinatesUtil.getBoxCoordinatesFromArguments(optionValues)));
    }
}
