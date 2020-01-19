package com.nazkord;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesUtilTest {

    @Test
    public void testConvertingToCoordinates() {
        String[] coordinatesArray = {"12","32","15","37","10"};
        String coordinates = "12,32,15,37,10";
        assertEquals(coordinates, CoordinatesUtil.convertToString(coordinatesArray));
    }

    @Test
    public void testGettingCoordinatesFromArguments() {
        String[] arguments = {"12","32","15","37","10","WIND"};
        String[] expectedArray = {"12","32","15","37","10"};
        assertArrayEquals(expectedArray, CoordinatesUtil.getCoordinatesFromArguments(arguments));
    }
}