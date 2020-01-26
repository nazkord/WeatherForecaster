package com.nazkord.options;

import org.apache.commons.cli.Option;

public class UVOption {

    public static final String UV = "uv";

    public static Option createUVOption() {
        return Option.builder(UV)
                .hasArgs()
                .argName("COORDINATES (lat,lon)")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities")
                .build();
    }
}
