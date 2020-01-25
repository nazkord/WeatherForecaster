package com.nazkord.model;

import java.util.ArrayList;
import java.util.Objects;

public class CurrentWeather {
    private Coordinates coord;
    private ArrayList<Weather> weather = new ArrayList<Weather>();
    private String base;
    private Main main;
    private float visibility;
    Wind wind;
    Clouds clouds;
    private float dt;
    private float id;
    private String name;
    private float cod;

    // Getter Methods

    public Coordinates getCoord() {
        return coord;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public float getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public float getDt() {
        return dt;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCod() {
        return cod;
    }

    // Setter Methods

    public void setCoord(Coordinates coordObject ) {
        this.coord = coordObject;
    }

    public void setBase( String base ) {
        this.base = base;
    }

    public void setMain( Main mainObject ) {
        this.main = mainObject;
    }

    public void setVisibility( float visibility ) {
        this.visibility = visibility;
    }

    public void setWind( Wind windObject ) {
        this.wind = windObject;
    }

    public void setClouds( Clouds cloudsObject ) {
        this.clouds = cloudsObject;
    }

    public void setDt( float dt ) {
        this.dt = dt;
    }

    public void setId( float id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setCod( float cod ) {
        this.cod = cod;
    }

    public CurrentWeather(Coordinates coord, ArrayList<Weather> weather, String base, Main main, float visibility, Wind wind, Clouds clouds, float dt, float id, String name, float cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentWeather)) return false;
        CurrentWeather that = (CurrentWeather) o;
        return Float.compare(that.visibility, visibility) == 0 &&
                Float.compare(that.dt, dt) == 0 &&
                Float.compare(that.id, id) == 0 &&
                Float.compare(that.cod, cod) == 0 &&
                Objects.equals(coord, that.coord) &&
                Objects.equals(weather, that.weather) &&
                Objects.equals(base, that.base) &&
                Objects.equals(main, that.main) &&
                Objects.equals(wind, that.wind) &&
                Objects.equals(clouds, that.clouds) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, weather, base, main, visibility, wind, clouds, dt, id, name, cod);
    }
}