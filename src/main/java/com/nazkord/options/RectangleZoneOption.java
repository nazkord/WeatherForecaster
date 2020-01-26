package com.nazkord.options;

import com.nazkord.model.Parameter;
import org.apache.commons.cli.Option;

public class RectangleZoneOption {

    public static final String RECTANGLE = "r";

    public static Option createRectangleZoneOption() {
        return Option.builder(RECTANGLE)
                .longOpt("Rectangle_Zone")
                .numberOfArgs(6)
                .argName("lon-left> <lat-bottom> <lon-right> <lat-top> <zoom> <PARAMETER")
                .valueSeparator(',')
                .desc("display city (inside rectangle zone) with biggest hesitation of provided parameter")
                .build();
    }

    public static Parameter getParameter(String[] args) {
        return Parameter.valueOf(args[5]);
    }
}
