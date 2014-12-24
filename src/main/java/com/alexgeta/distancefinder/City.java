package com.alexgeta.distancefinder;

import java.util.HashMap;
import java.util.Map;

/**
 * City entity
 * 
 * @author Alex Geta
 */
public class City {

    private final String name;
    /*shortest distance from start city*/
    private int distance = Integer.MAX_VALUE;
    /*neighbour cities and distances between them*/
    private final Map<City, Integer> directions = new HashMap<City, Integer>();

    public City(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<City, Integer> getDirections() {
        return directions;
    }

    public void addDirection(City city, int distance){
        directions.put(city, distance);
        /*add backward connection*/
        city.getDirections().put(this, distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
