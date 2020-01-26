package com.nazkord.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void parseFromUnixTime() {
        String unixTime = "1578409200";
        String expectedDate = "2020-01-07";
        assertEquals(expectedDate, DateUtil.getDate(unixTime));
    }

    @Test
    public void parseFromUnixTimeToHour() {
        String unixTime = "1578409200";
        String expectedDate = "16";
        assertEquals(expectedDate, DateUtil.getHour(unixTime));
    }
}