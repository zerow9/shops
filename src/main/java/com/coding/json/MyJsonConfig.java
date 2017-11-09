package com.coding.json;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import java.util.Date;
import java.util.List;

public class MyJsonConfig<E> {

    public String start(List<E> list, int count) {
        JsonConfig config = new JsonConfig();
        JsonFormat json = new JsonFormat();
        config.registerJsonValueProcessor(Date.class, json);
        JSONArray array = new JSONArray();
        array = array.fromObject(list, config);
        return "{\"code\":\"\",\"count\":" + count + ",\"data\":" + array.toString() + ",\"msg\":\"\"}";
    }

}
