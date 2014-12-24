package com.alexgeta.distancefinder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Geta
 */
public class Main {


    public static void main(String[] args) throws Exception{

        Map<String, City> cities = new HashMap<String, City>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        System.out.println("Please enter city name...");
        while (!(input = reader.readLine()).isEmpty()){
            City city = new City(input);
            cities.put(input, city);
            System.out.println("City "+city+" was successfully created!");
            System.out.println();
            System.out.println("Enter next city name, or simply press ENTER to continue...");
        }

        for(City city : cities.values()){

            System.out.println("Please enter neighbour name for city "+city+" ...");
            System.out.println("Available names : "+cities.values());

            while (!(input = reader.readLine()).isEmpty()){

            City neighbour = cities.get(input);
            if (neighbour == null) {
                System.out.println(input+" name is incorrect, please try again");
                continue;
            }

            int distance = 0;
            while (distance < 1){
                System.out.println("Please enter an integer value greater than 0 for distance from "+city+" to "+neighbour);
                input = reader.readLine();
                try {
                    distance = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println(input+" is not an integer, try again...");
                }
            }

            city.addDirection(neighbour,distance);
            System.out.println(neighbour+" was successfully added as direction to "+
                    city+" with distance between them "+distance);
                System.out.println("Please enter next neighbour name for city "+city+
                        " or simply press ENTER to proceed to next city");
            }
        }

        System.out.println("Please enter start city name...");
        System.out.println("Available names : "+cities.values());
        input = reader.readLine();
        City start = cities.get(input);

        System.out.println("Please enter finish city name...");
        System.out.println("Available names : "+cities.values());
        input = reader.readLine();
        City finish = cities.get(input);

        ShortDistanceFinder finder = new ShortDistanceFinder();
        int shortestWay = finder.findShortestWay(start, finish);
        System.out.println("Shortest distance between "+start+" and "+finish+" is "+shortestWay);

    }

}
