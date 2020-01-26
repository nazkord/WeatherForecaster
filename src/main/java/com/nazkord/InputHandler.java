package com.nazkord;

import com.nazkord.fetchers.Fetcher;
import com.nazkord.fetchers.FetcherFactory;
import com.nazkord.options.OptionInitializer;
import com.nazkord.utils.CLIUtil;
import org.apache.commons.cli.*;

public class InputHandler {
    private static HelpFormatter formatter = new HelpFormatter();
    private static CommandLineParser parser = new DefaultParser();
    private static CommandLine cmd;

    public static void parseArguments(String[] args) {
        Options options = OptionInitializer.initialize();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("cli-weatherApp", options);
            System.exit(1);
        }

        Fetcher fetcher = FetcherFactory.createFetcher(CLIUtil.getAvailableOption(cmd));
        fetcher.fetch(cmd.getOptionValues(fetcher.getFetcherOptionName()));
    }
}