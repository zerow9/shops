package com.coding.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTool {

    //    日期转字符串
    public String dateToString(Date date, String type) {
        String str = null;
        if (type.equals("SHORT")) {
            str = new SimpleDateFormat("yy-MM-dd").format(date);
        } else if (type.equals("MEDIUM")) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(date);
        } else if (type.equals("FULL")) {
            // 20017年11月11日 星期六
            str = DateFormat.getDateInstance(DateFormat.FULL).format(date);
        } else if (type.equals("FULL_TIME")) {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }
        return str;
    }

    public Date stringToDate(String str, String type) {
        Date date = null;
        try {
            if (type.equals("SHORT")) {
                date = new SimpleDateFormat("yy-MM-dd").parse(str);
            } else if (type.equals("MEDIUM")) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } else if (type.equals("FULL")) {
                // 20017年11月11日 星期六
                date = DateFormat.getDateInstance(DateFormat.FULL).parse(str);
            } else if (type.equals("FULL_TIME")) {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
