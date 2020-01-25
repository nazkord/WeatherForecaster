package com.nazkord.utils;

import com.nazkord.model.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesUtil {
    public static String convertToString(String[] coordinatesArray) {
        StringBuilder coordinates = new StringBuilder();
        for (String coordinate:
                coordinatesArray) {
            coordinates.append(coordinate);
            coordinates.append(',');
        }
        coordinates.deleteCharAt(coordinates.lastIndexOf(","));
        return coordinates.toString();
    }

    public static String[] getBoxCoordinatesFromArguments(String[] arguments) {
        String[] coordinates = new String[arguments.length - 1];
        System.arraycopy(arguments, 0, coordinates, 0, arguments.length - 1);
        return coordinates;
    }

    public static List<Coordinates> getListOfCoordinates(String[] coordinates) {
        List<Coordinates> coordinatesList = new ArrayList<>();
        for (int i = 0; i < coordinates.length - 1; i+=2) {
            coordinatesList.add(new Coordinates(coordinates[i], coordinates[i+1]));
        }
        return coordinatesList;
    }
}
