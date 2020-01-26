package com.nazkord.options;

import com.nazkord.model.Coordinates;
import javafx.util.Pair;
import org.apache.commons.cli.Option;

import java.util.Map;

public class UVOption {

    public static final String UV = "uv";

    public static Option createUVOption() {
        return Option.builder(UV)
                .hasArgs()
                .argName("COORDINATES (lat,lon)")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities")
                .build();
    }

    public static void draw(Map<Coordinates, Pair<Float, Float>> uvValuesMap) {
        uvValuesMap.forEach((c, valuePairs) -> {
            System.out.println("Coordinates: lat: " + c.getLat() + " lon: " + c.getLon());
            System.out.println("Min value: " + valuePairs.getKey() + " Max value: " + valuePairs.getValue() + "\n");
        });
    }
}
