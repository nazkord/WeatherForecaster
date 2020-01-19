package com.nazkord;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OkHttpCommunication {

    private static final String URL = "https://api.openweathermap.org/data/2.5";
    public static final String WEATHER = "/weather";
    public static final String FORECAST = "/forecast";
    private static final String UV = "/uvi";
    private static final String APIKEY = "8930138d8ad840392f3e01aa2ef43c58";
    private static final OkHttpCommunication INSTANCE = new OkHttpCommunication();

    private OkHttpCommunication() {
    }

    public static OkHttpCommunication getInstance() {
        return INSTANCE;
    }

    public String getWeatherByCity(String city, String typeOfWeather) {
        HttpUrl.Builder httpUrl = createHttpUrlBuilderWithCity(typeOfWeather, city);
        Request request = createRequest(httpUrl);

        try (Response response = OkHttpClientSingleton.getOkHttpClient().newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            System.out.println("Exception while getting data from server: " + e.getMessage());
            return null;
        }
    }

    public String getUVFromCities(List<String> cities) {
        return null;
    }

    private void addKeyApi(HttpUrl.Builder httpUrl) {
        httpUrl.addQueryParameter("APPID", APIKEY);
    }

    private Request createRequest(HttpUrl.Builder httpUrl) {
        return new Request.Builder()
                .url(httpUrl.build())
                .build();
    }

    private HttpUrl.Builder createHttpUrlBuilderWithCity(String endPoint, String city) {
        HttpUrl.Builder httpUrl = Objects.requireNonNull(HttpUrl.parse(URL + endPoint))
                .newBuilder()
                .addQueryParameter("q", city);
        addKeyApi(httpUrl);
        return httpUrl;
    }
}
