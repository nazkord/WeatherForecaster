package com.nazkord;

import com.nazkord.model.Coordinates;
import com.nazkord.utils.CoordinatesUtil;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class OkHttpCommunication {

    private static final String URL = "https://api.openweathermap.org/data/2.5";
    public static final String WEATHER = "/weather";
    public static final String FORECAST = "/forecast";
    private static final String UV = "/uvi";
    private static final String API_KEY = "8930138d8ad840392f3e01aa2ef43c58";
    private static final String RECTANGLE_ZONE = "/box/city";
    private static final OkHttpCommunication INSTANCE = new OkHttpCommunication();

    private OkHttpCommunication() {
    }

    public static OkHttpCommunication getInstance() {
        return INSTANCE;
    }

    public String getWeatherByCity(String city, String typeOfWeather) {
        HttpUrl.Builder httpUrl = createHttpUrlBuilder(typeOfWeather);
        httpUrl.addQueryParameter("q", city);

        return getResponse(httpUrl);
    }

    public String getUVForecastFromCoordinates(Coordinates coordinates) {
        HttpUrl.Builder httpUrlBuilder = createHttpUrlBuilder(UV + FORECAST);
        UVHttpHelper.addRequiredParams(httpUrlBuilder, coordinates);

        return getResponse(httpUrlBuilder);
    }

    public String getUVHistoricalFromCoordinates(Coordinates coordinates) {
        HttpUrl.Builder httpUrlBuilder = createHttpUrlBuilder(UV + "/history");
        UVHttpHelper.addHistoricalParamsToHttpUrl(httpUrlBuilder, coordinates);

        return getResponse(httpUrlBuilder);
    }

    public String getRectangleZone(String[] coordinatesArray) {
        HttpUrl.Builder httpUrlBuilder = createHttpUrlBuilder(RECTANGLE_ZONE);
        httpUrlBuilder.addQueryParameter("bbox", CoordinatesUtil.convertToString(coordinatesArray));

        return getResponse(httpUrlBuilder);
    }

    private String getResponse(HttpUrl.Builder httpUrl) {
        Request request = createRequest(httpUrl);
        try (Response response = OkHttpClientSingleton.getOkHttpClient().newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            System.out.println("Exception while getting data from server: " + e.getMessage());
            return null;
        }
    }

    private Request createRequest(HttpUrl.Builder httpUrl) {
        return new Request.Builder()
                .url(httpUrl.build())
                .build();
    }

    private HttpUrl.Builder createHttpUrlBuilder(String endPoint) {
        return Objects.requireNonNull(HttpUrl.parse(URL + endPoint))
                .newBuilder()
                .addQueryParameter("APPID", API_KEY)
                .addQueryParameter("units", "metric");
    }
}
