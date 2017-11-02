package com.coding.comomInterface;

import org.joda.time.DateTime;
import java.util.Date;

public class DateToString {

    public static String change(Date date) {
        return date(date);
    }

    public static String nowDate() {
        return  date(null);
    }

    public static String date(Date date) {
        if(date==null)
            date=new Date();
      return new DateTime(date.getTime()).toString("yyyy-MM-dd HH:mm:ss");
    }

}
