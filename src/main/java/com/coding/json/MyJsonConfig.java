package com.coding.json;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.util.Date;
import java.util.List;

public class MyJsonConfig<E> {

    private String config(List<E> list, int count, String msg) {
        if (msg == null)
            msg = "\"\"";
        JsonConfig config = new JsonConfig();
        JsonFormat json = new JsonFormat();
        config.registerJsonValueProcessor(Date.class, json);
        JSONArray array = new JSONArray();
        array = array.fromObject(list, config);
        return "{\"code\":\"\",\"count\":" + count + ",\"data\":" + array.toString() + ",\"msg\":"+msg+"}";
    }


    public String start(List<E> list, int count) {
        return config(list, count, null);
    }

    public String start(List<E> list, int count, String msg) {
        return config(list, count, msg);
    }

}
