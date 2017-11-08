package com.coding.comomInterface;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import java.util.Date;

public class DateToString {

    private static String pattern="yyyy-MM-dd HH:mm:ss";

    public static String date(Date date) {
        return new DateTime(date.getTime()).toString(pattern);
    }

    public static Date date(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern)).toDate();
    }

    public static void main(String[] args) throws Exception {
    }

}
