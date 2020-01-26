package com.nazkord.utils;

import com.nazkord.options.OptionNames;
import org.apache.commons.cli.CommandLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CLIUtil {
    private static boolean isAvailable(CommandLine cmd, String option) {
        return cmd.getOptionValues(option) != null;
    }

    public static OptionNames getAvailableOption(CommandLine cmd) {
        List<OptionNames> options = Arrays.asList(OptionNames.values());
        return options.stream()
                .filter(optionNames -> isAvailable(cmd, optionNames.getName()))
                .collect(Collectors.toList())
                .get(0);
    }
}
