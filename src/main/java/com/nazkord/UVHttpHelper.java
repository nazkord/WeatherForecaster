package com.nazkord;

import com.nazkord.model.Coordinates;
import okhttp3.HttpUrl;
import java.time.temporal.ChronoUnit;

import java.time.Instant;

public class UVHttpHelper {

    public static void addHistoricalParamsToHttpUrl(HttpUrl.Builder httpUrlBuilder, Coordinates coordinates) {
        addRequiredParams(httpUrlBuilder, coordinates);
        httpUrlBuilder.addQueryParameter("start", getUnixTimeMinusWeek().toString());
        httpUrlBuilder.addQueryParameter("end", getCurrentUnixTime().toString());
    }

    public static void addRequiredParams(HttpUrl.Builder httpUrlBuilder, Coordinates coordinates) {
        httpUrlBuilder.addQueryParameter("lat", coordinates.getLat());
        httpUrlBuilder.addQueryParameter( "lon", coordinates.getLon());
    }

    private static Long getCurrentUnixTime() {
        return Instant.now().getEpochSecond();
    }

    private static Long getUnixTimeMinusWeek() {
        return Instant.now().minus(8, ChronoUnit.DAYS).getEpochSecond();
    }


}
