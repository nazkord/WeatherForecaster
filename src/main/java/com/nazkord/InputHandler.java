package com.nazkord;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class InputHandler {
    private static HelpFormatter formatter = new HelpFormatter();
    private static CommandLineParser parser = new DefaultParser();
    private static CommandLine cmd;

    public static void parseArguments(String[] args) {
        try {
            cmd = parser.parse(CLIOptions.getOptions(), args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("cli-weatherApp", CLIOptions.getOptions());
            System.exit(1);
        }
        retrieveCityOption();
        retrieveDayInfoOption();
        retrieveUVOption();
    }

    //TODO: replace with one method!

    private static void retrieveCityOption() {
        String city = cmd.getOptionValue(CLIOptions.City);
        if(city != null) {
            System.out.println("City: " + city);
        }
    }

    private static void retrieveDayInfoOption() {
        String[] optionValues = cmd.getOptionValues(CLIOptions.Parameter);
        if(optionValues != null) {
            System.out.println(Arrays.toString(optionValues));
        }
    }

    private static void retrieveUVOption() {
        String[] optionValues = cmd.getOptionValues(CLIOptions.UV);
        if(optionValues != null) {
            System.out.println(Arrays.toString(optionValues));
        }
    }

}
