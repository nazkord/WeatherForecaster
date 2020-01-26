package com.nazkord.options;

import org.apache.commons.cli.Option;

public class ParameterOption {

    public static final String PARAMETER = "p";

    public static Option createInfoParameterOption() {
        return Option.builder(PARAMETER)
                .longOpt("Parameter")
                .numberOfArgs(4)
                .argName("DATE> <HOUR> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter about city in particular date (up to 5 days ahead from today)")
                .build();
    }
}
