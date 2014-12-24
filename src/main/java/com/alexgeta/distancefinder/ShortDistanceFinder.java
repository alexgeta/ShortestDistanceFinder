package com.alexgeta.distancefinder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex Geta
 */
public class ShortDistanceFinder {

    private Set<City> calculatedCities = new HashSet<City>();

    public int findShortestWay(City start, City finish) {

        start.setDistance(0);
        City nextCity = start;
        while (!calculatedCities.containsAll(nextCity.getDirections().keySet())){
            calculateNeighbours(nextCity);
            nextCity = getNearestNeighbor(nextCity);
        }
        return finish.getDistance();
    }

    /*returns nearest neighbour city*/
    private City getNearestNeighbor(City city) {

        Map<City, Integer> neighbours = city.getDirections();
        City nearestNeighbour = city;
        int minDistance = Integer.MAX_VALUE;

        for(Map.Entry<City, Integer> neighbour : neighbours.entrySet()){
            if(calculatedCities.contains(neighbour.getKey())) continue;
            if (neighbour.getValue() < minDistance){
                minDistance = neighbour.getValue();
                nearestNeighbour = neighbour.getKey();
            }
        }
        return nearestNeighbour;
    }

    /*calculate distance from start to all neighbour cities*/
    private void calculateNeighbours(City city){

        Map<City, Integer> neighbours = city.getDirections();
        for(Map.Entry<City, Integer> neighbour : neighbours.entrySet()){
            City neighbourCity = neighbour.getKey();
            Integer distance = neighbour.getValue();
            int summaryDistance = city.getDistance() + distance;
            if(summaryDistance < neighbourCity.getDistance()){
                neighbourCity.setDistance(summaryDistance);
            }
        }
        calculatedCities.add(city);
    }

}
