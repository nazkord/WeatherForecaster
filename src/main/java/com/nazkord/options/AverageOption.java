package com.nazkord.options;

import org.apache.commons.cli.Option;

public class AverageOption {

    public static final String AVERAGE = "av";

    public static Option createAverageParameterOption() {
        return Option.builder(AVERAGE)
                .longOpt("Average")
                .numberOfArgs(2)
                .argName("CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display average value of provided parameter for city")
                .build();
    }
}
