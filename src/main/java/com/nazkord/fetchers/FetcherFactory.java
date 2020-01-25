package com.nazkord.fetchers;

import com.nazkord.OptionNames;

public class FetcherFactory {

    public static Fetcher createFetcher(OptionNames option) {
        switch (option) {
            case UV: {
                return new UVFetcher(OptionNames.UV.getName());
            }
            case CITY: {
                return new CityFetcher(OptionNames.CITY.getName());
            }
            case PARAMETER: {
                return new ParameterFetcher(OptionNames.PARAMETER.getName());
            }
            case AVERAGE : {
                return new AverageFetcher(OptionNames.AVERAGE.getName());
            }
            case RECTANGLE: {
                return new RectangleFetcher(OptionNames.RECTANGLE.getName());
            }
            case DIAGRAM: {
                return new DiagramFetcher(OptionNames.DIAGRAM.getName());
            }
            default: {
                return null;
            }
        }
    }
}
