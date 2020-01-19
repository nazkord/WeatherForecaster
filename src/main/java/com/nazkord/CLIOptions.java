package com.nazkord;

import org.apache.commons.cli.*;

import java.util.regex.Pattern;

public enum CLIOptions {

    OPTIONS();

    private Options options;
    public static final String UV = "uv";
    public static final String CITY = "c";
    public static final String PARAMETER = "p";
    public static final String AVERAGE = "p";

    CLIOptions() {
        options = new Options();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(createTownOption());
        optionGroup.addOption(createDayInfoOption());
        optionGroup.addOption(createUVOption());
        optionGroup.addOption(createAverageOption());
        optionGroup.setRequired(true);
        options.addOptionGroup(optionGroup);
    }

    public Options getOptions() {
        return options;
    }

    private static Option createTownOption() {
        return new Option(CITY, "CITY", true, "display current weather about particular City");
    }

    //TODO: make enum list of parameters

    private static Option createDayInfoOption() {
        return Option.builder(PARAMETER)
                .longOpt("parameter")
                .numberOfArgs(3)
                .argName("DATE> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter about city in particular date (up to 5 days ahead from today)\n " +
                        "Provide arguments with coma (,) \n " +
                        "Provide parameters in \"\" \n")
                .build();
    }

    private static Option createUVOption() {
        return Option.builder(UV)
                .hasArgs()
                .argName("Cities")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities. \n " +
                        "Provide arguments with coma (,)")
                .build();
    }

    private static Option createAverageOption() {
        return Option.builder(AVERAGE)
                .longOpt("Average")
                .numberOfArgs(2)
                .argName("CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display average value of provided parameter for city \n" +
                        "Provide arguments with coma (,)")
                .build();
    }
}
