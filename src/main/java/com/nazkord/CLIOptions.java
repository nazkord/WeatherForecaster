package com.nazkord;

import org.apache.commons.cli.*;

public enum CLIOptions {

    OPTIONS();

    private Options options;

    CLIOptions() {
        options = new Options();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(createTownOption());
        optionGroup.addOption(createInfoParameterOption());
        optionGroup.addOption(createUVOption());
        optionGroup.addOption(createAverageParameterOption());
        optionGroup.addOption(createRectangleZoneOption());
        optionGroup.addOption(createDiagramOption());
        optionGroup.setRequired(true);
        options.addOptionGroup(optionGroup);
    }

    public Options getOptions() {
        return options;
    }

    private static Option createTownOption() {
        return new Option(OptionNames.CITY.getName(), "City", true, "display current weather about particular City");
    }

    //TODO: make enum list of parameters

    private static Option createInfoParameterOption() {
        return Option.builder(OptionNames.PARAMETER.getName())
                .longOpt("Parameter")
                .numberOfArgs(3)
                .argName("DATE> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter about city in particular date (up to 5 days ahead from today)")
                .build();
    }

    private static Option createUVOption() {
        return Option.builder(OptionNames.UV.getName())
                .hasArgs()
                .argName("COORDINATES (lat,lon)")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities")
                .build();
    }

    private static Option createAverageParameterOption() {
        return Option.builder(OptionNames.AVERAGE.getName())
                .longOpt("Average")
                .numberOfArgs(2)
                .argName("CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display average value of provided parameter for city")
                .build();
    }

    private static Option createRectangleZoneOption() {
        return Option.builder(OptionNames.RECTANGLE.getName())
                .longOpt("Rectangle_Zone")
                .numberOfArgs(6)
                .argName("lon-left> <lat-bottom> <lon-right> <lat-top> <zoom> <PARAMETER")
                .valueSeparator(',')
                .desc("display city (inside rectangle zone) with biggest hesitation of provided parameter")
                .build();
    }

    private static Option createDiagramOption() {
        return Option.builder(OptionNames.DIAGRAM.getName())
                .longOpt("Cities_diagram")
                .hasArgs()
                .argName("PARAMETER> <CITIES> <START TIME> <END DATETIME")
                .valueSeparator(',')
                .desc("display diagram about changing of provided parameter in cities")
                .build();
    }
}
