package com.nazkord;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class InputHandler {
    private static HelpFormatter formatter = new HelpFormatter();
    private static CommandLineParser parser = new DefaultParser();
    private static CommandLine cmd;

    public static void parseArguments(String[] args) {
        try {
            cmd = parser.parse(CLIOptions.OPTIONS.getOptions(), args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("cli-weatherApp", CLIOptions.OPTIONS.getOptions());
            System.exit(1);
        }
        retrieveCityOption();
        retrieveDayInfoOption();
        retrieveUVOption();
    }

    //TODO: replace with one method!

    private static void retrieveCityOption() {
        String city = cmd.getOptionValue(CLIOptions.CITY);
        if(city != null) {
            System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(city, OkHttpCommunication.WEATHER));
        }
    }

    private static void retrieveDayInfoOption() {
        String[] optionValues = cmd.getOptionValues(CLIOptions.PARAMETER);
        if(optionValues != null) {
            System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(optionValues[1], OkHttpCommunication.FORECAST));
        }
    }

    private static void retrieveUVOption() {
        String[] optionValues = cmd.getOptionValues(CLIOptions.UV);
        if(optionValues != null) {
            System.out.println(Arrays.toString(optionValues));
        }
    }

    private static void retrieveAverageOption() {
        String[] optionValues = cmd.getOptionValues(CLIOptions.AVERAGE);
        if(optionValues != null) {
            System.out.println(OkHttpCommunication.getInstance().getWeatherByCity(optionValues[0], OkHttpCommunication.FORECAST));
        }
    }

}
