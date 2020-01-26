package com.nazkord.parsers;

import com.nazkord.model.CurrentWeather;
import com.nazkord.model.ForecastWeather;
import com.nazkord.model.Parameter;
import com.nazkord.options.ParameterOption;
import com.nazkord.utils.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ParameterParser {

    public static Float parse(ForecastWeather forecast, String[] args) {
        String date = ParameterOption.getDate(args);
        Integer hour = ParameterOption.getHour(args);
        Parameter parameter = ParameterOption.getParameter(args);
        List<CurrentWeather> weathersOfDay = getCurrentWeatherByDate(forecast.getList(), date);
        CurrentWeather currentWeather = getCurrentWeatherByHour(weathersOfDay, hour);
        return Parameter.getParameter(currentWeather, parameter);
    }

    private static List<CurrentWeather> getCurrentWeatherByDate(List<CurrentWeather> currentWeatherList, String date) {
        return currentWeatherList.stream()
                .filter(cW -> date.equals(DateUtil.getDate(cW.getDt_txt())))
                .collect(Collectors.toList());
    }

    private static CurrentWeather getCurrentWeatherByHour(List<CurrentWeather> currentWeathers, Integer hour) {
        return currentWeathers.stream()
                .filter(cW -> {
                    Integer weatherHour = Integer.parseInt(DateUtil.getHour(cW.getDt_txt()));
                    return hour.equals(weatherHour);
                })
                .collect(Collectors.toList()).get(0);
    }
}