package com.nazkord.utils;

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

    public static String[] getCoordinatesFromArguments(String[] arguments) {
        String[] coordinates = new String[arguments.length - 1];
        System.arraycopy(arguments, 0, coordinates, 0, arguments.length - 1);
        return coordinates;
    }
}
