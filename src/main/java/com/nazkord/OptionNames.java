package com.nazkord;

public enum OptionNames {

    UV("uv"),
    CITY("c"),
    PARAMETER("p"),
    AVERAGE("av"),
    RECTANGLE("r"),
    DIAGRAM("d");

    private String name;

    OptionNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
