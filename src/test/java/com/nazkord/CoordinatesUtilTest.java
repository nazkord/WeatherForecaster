package com.nazkord;

import com.nazkord.model.Coordinates;
import com.nazkord.utils.CoordinatesUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CoordinatesUtilTest {

    @Test
    public void testConvertingToCoordinates() {
        String[] coordinatesArray = {"12","32","15","37","10"};
        String coordinates = "12,32,15,37,10";
        assertEquals(coordinates, CoordinatesUtil.convertToString(coordinatesArray));
    }

    @Test
    public void testGettingBoxCoordinatesFromArguments() {
        String[] arguments = {"12","32","15","37","10","WIND"};
        String[] expectedArray = {"12","32","15","37","10"};
        assertArrayEquals(expectedArray, CoordinatesUtil.getBoxCoordinatesFromArguments(arguments));
    }

    @Test
    public void testGettingListOfCoordinatesFromArguments() {
        String[] arguments = {"12.5","-32.1","15.3","-37.9","10"};
        List<Coordinates> actual = CoordinatesUtil.getListOfCoordinates(arguments);

        //TODO: compare lists!!!
        assertEquals(actual.size(), 2);
        assertEquals(actual.get(0), new Coordinates("12.5", "-32.1"));
        assertEquals(actual.get(1), new Coordinates("15.3", "-37.9"));
    }
}