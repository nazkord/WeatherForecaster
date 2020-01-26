package com.nazkord.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    public static Date parseFromUnixTime(String unixTime) {
        return new Date(Long.parseLong(unixTime) * 1000);
    }

    public static String getDate(String dateInString) {
        return dateInString.substring(0,10);
    }

    public static String getHour(String dateInString) {
        return dateInString.substring(11,13);
    }
}
