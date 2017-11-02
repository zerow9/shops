package com.coding.comomInterface;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {

    public static String change(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static int age(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year=format.format(date);
        return 2017-Integer.valueOf(year);
    }
}
