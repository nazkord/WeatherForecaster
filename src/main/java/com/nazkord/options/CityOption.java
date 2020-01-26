package com.nazkord.options;

import org.apache.commons.cli.Option;

public class CityOption {

    public static final String CITY = "c";

    public static Option createCityOption() {
        return new Option(CITY, "City", true, "display current weather about particular City");
    }
}
