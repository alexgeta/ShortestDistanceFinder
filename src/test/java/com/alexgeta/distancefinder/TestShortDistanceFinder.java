package com.alexgeta.distancefinder;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alex Geta
 */
public class TestShortDistanceFinder {

    @Test
    public void testFinder() throws Exception {
        ShortDistanceFinder finder = new ShortDistanceFinder();

        City kharkov =  new City("kharkov");
        City kiev =  new City("kiev");
        City dnepr =  new City("dnepr");
        City odessa =  new City("odessa");
        City lviv =  new City("lviv");
        City poltava =  new City("poltava");

        kharkov.addDirection(odessa, 4);
        kharkov.addDirection(kiev, 2);
        kharkov.addDirection(dnepr, 1);

        kiev.addDirection(odessa, 7);
        kiev.addDirection(lviv, 3);

        dnepr.addDirection(odessa, 5);
        dnepr.addDirection(lviv, 10);
        dnepr.addDirection(poltava, 4);

        odessa.addDirection(poltava, 5);

        lviv.addDirection(poltava, 4);

        City start = kharkov;
        City finish = poltava;

        int expected = 5;
        int shortestWay = finder.findShortestWay(start, finish);
        assertTrue(shortestWay == expected);

    }
}
