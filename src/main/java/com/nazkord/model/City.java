package com.nazkord.model;

import lombok.Data;

@Data
public class City {
    private Long id;
    private String name;
    private Coordinates coord;
    private String country;
}
