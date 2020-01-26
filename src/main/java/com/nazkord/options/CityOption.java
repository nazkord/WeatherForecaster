package com.nazkord.options;

import com.nazkord.model.CurrentWeather;
import com.nazkord.model.Parameter;
import org.apache.commons.cli.Option;

public class CityOption {

    public static final String CITY = "c";

    public static Option createCityOption() {
        return new Option(CITY, "City", true, "display current weather about particular City");
    }

    public static void draw(CurrentWeather currentWeather) {
        String stringBuilder = "City: " + currentWeather.getName() + "\n" +
                "Weather: " + currentWeather.getWeather().get(0).getMain() +
                " - " + currentWeather.getWeather().get(0).getDescription() + "\n" +
                Parameter.getParameterDrawer(Parameter.PRESSURE, currentWeather.getMain().getPressure()) +
                Parameter.getParameterDrawer(Parameter.HUMIDITY, currentWeather.getMain().getHumidity()) +
                Parameter.getParameterDrawer(Parameter.TEMP, currentWeather.getMain().getTemp()) +
                Parameter.getParameterDrawer(Parameter.WIND_SPEED, currentWeather.getWind().getSpeed()) +
                Parameter.getParameterDrawer(Parameter.CLOUDINESS, currentWeather.getClouds().getAll());
        System.out.println(stringBuilder);
    }
}
