package com.nazkord.options;

import com.nazkord.model.Parameter;
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

    public static String getCity(String[] args) {
        return args[0];
    }

    public static Parameter getParameter(String[] args) {
        return Parameter.valueOf(args[1]);
    }
}
