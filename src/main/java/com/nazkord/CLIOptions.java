package com.nazkord;

import org.apache.commons.cli.*;

public enum CLIOptions {

    OPTIONS();

    private Options options;
    public static final String UV = "uv";
    public static final String CITY = "c";
    public static final String PARAMETER = "p";
    public static final String AVERAGE = "av";
    public static final String RECTANGLE = "r";

    CLIOptions() {
        options = new Options();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(createTownOption());
        optionGroup.addOption(createInfoParameterOption());
        optionGroup.addOption(createUVOption());
        optionGroup.addOption(createAverageParameterOption());
        optionGroup.addOption(createRectangleZoneOption());
        optionGroup.setRequired(true);
        options.addOptionGroup(optionGroup);
    }

    public Options getOptions() {
        return options;
    }

    private static Option createTownOption() {
        return new Option(CITY, "City", true, "display current weather about particular City");
    }

    //TODO: make enum list of parameters

    private static Option createInfoParameterOption() {
        return Option.builder(PARAMETER)
                .longOpt("Parameter")
                .numberOfArgs(3)
                .argName("DATE> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter about city in particular date (up to 5 days ahead from today)")
                .build();
    }

    private static Option createUVOption() {
        return Option.builder(UV)
                .hasArgs()
                .argName("Cities")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities")
                .build();
    }

    private static Option createAverageParameterOption() {
        return Option.builder(AVERAGE)
                .longOpt("Average")
                .numberOfArgs(2)
                .argName("CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display average value of provided parameter for city")
                .build();
    }

    private static Option createRectangleZoneOption() {
        return Option.builder(RECTANGLE)
                .longOpt("Rectangle Zone")
                .numberOfArgs(6)
                .argName("lon-left> <lat-bottom> <lon-right> <lat-top> <zoom> <PARAMETER")
                .valueSeparator(',')
                .desc("display city (inside rectangle zone) with biggest hesitation of provided parameter")
                .build();
    }
}
