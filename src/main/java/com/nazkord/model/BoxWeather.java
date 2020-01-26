package com.nazkord.model;

import lombok.Data;

import java.util.List;

@Data
public class BoxWeather {
    List<CurrentWeather> list;
}
