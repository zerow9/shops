package com.coding.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String string) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(string);
        } catch (ParseException e) {
        }
        format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}