package com.nazkord;

import org.apache.commons.cli.*;

public class CLIOptions {

    private static Options options;
    public static final String UV = "uv";
    public static final String City = "c";
    public static final String Parameter = "p";

    public static Options getOptions() {
        if (options == null) {
            synchronized (CLIOptions.class) {
                if (options == null) {
                    options = createOptionGroup();

                }
            }
        }
        return options;
    }

    private static Options createOptionGroup() {
        Options options = new Options();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(createTownOption());
        optionGroup.addOption(createDayInfoOption());
        optionGroup.addOption(createUVOption());
        optionGroup.setRequired(true);
        options.addOptionGroup(optionGroup);
        return options;
    }

    private static Option createTownOption() {
        return new Option("c", "CITY", true, "display weather about particular City");
    }

    private static Option createDayInfoOption() {
        return Option.builder("p")
                .longOpt("parameter")
                .numberOfArgs(3)
                .argName("DATE> <CITY> <PARAMETER")
                .valueSeparator(',')
                .desc("display parameter about city in particular date \n " +
                        "Provide arguments with coma (,) \n " +
                        "Provide parameters in \"\" \n")
                .build();
    }

    private static Option createUVOption() {
        return Option.builder("uv")
                .hasArgs()
                .argName("Cities")
                .valueSeparator(',')
                .desc("information about UV radiation in provided cities. \n " +
                        "Provide arguments with coma (,)")
                .build();
    }
}
