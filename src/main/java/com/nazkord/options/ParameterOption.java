package com.nazkord.options;

import com.nazkord.model.Parameter;
import org.apache.commons.cli.Option;

public class ParameterOption {

    public static final String PARAMETER = "p";

    public static Option createInfoParameterOption() {
        return Option.builder(PARAMETER)
                .longOpt("Parameter")
                .numberOfArgs(4)
                .argName("DATE> <HOUR> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter " +
                        "about city in particular date (up to 5 days ahead from today)")
                .build();
    }

    //TODO: use it
    public static boolean validate(String[] arguments) {
        return true;
    }

    public static String getCity(String[] args) {
        return args[2];
    }

    public static Parameter getParameter(String[] args) {
        return Parameter.valueOf(args[3]);
    }

    public static String getDate(String[] args) {
        return args[0];
    }

    public static Integer getHour(String[] args) {
        return Integer.parseInt(args[1]);
    }
}
