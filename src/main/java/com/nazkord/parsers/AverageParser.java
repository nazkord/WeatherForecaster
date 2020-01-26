package com.nazkord.parsers;

import com.nazkord.model.ForecastWeather;
import com.nazkord.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class AverageParser {

    public static Float parse(ForecastWeather forecastWeather, Parameter parameter) {
        List<Float> values = new ArrayList<>();
        forecastWeather.getList()
                .forEach(cW -> values.add(Parameter.getParameter(cW, parameter)));
        return calculateAverage(values);
    }

    private static Float calculateAverage(List<Float> values) {
        Float sum = 0F;
        if(!values.isEmpty()) {
            for (Float mark : values) {
                sum += mark;
            }
            return sum / values.size();
        }
        return sum;
    }
}
