package com.nazkord.options;


import org.apache.commons.cli.Option;

public class DiagramOption {

    public static final String DIAGRAM = "d";

    public static Option createDiagramOption() {
        return Option.builder(DIAGRAM)
                .longOpt("Cities_diagram")
                .hasArgs()
                .argName("PARAMETER> <CITIES> <START TIME> <END DATETIME")
                .valueSeparator(',')
                .desc("display diagram about changing of provided parameter in cities")
                .build();
    }
}
