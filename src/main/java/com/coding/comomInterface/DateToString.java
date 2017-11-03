package com.coding.comomInterface;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateToString {

    public static String change(Date date) {
        return date(date);
    }

    public static String nowDate() {
        return date(null);
    }

    public static String date(Date date) {
        if (date == null)
            date = new Date();
        return new DateTime(date.getTime()).toString("yyyy-MM-dd HH:mm:ss");
    }

    public static Date toDate(String date) {
        return DateTime.parse(date, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate();
    }

    public static void main(String[] args) throws Exception {
    }

}
