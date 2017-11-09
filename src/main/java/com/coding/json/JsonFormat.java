package com.coding.json;


import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonFormat implements JsonValueProcessor {
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value) {
        if (value instanceof Date) {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(value);
        }
        return value;
    }
}