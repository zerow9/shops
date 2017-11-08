package com.coding.json;


import java.util.List;

public class JsonFormat<E> extends JSONTemplet {
    private List<E> data;

    public JsonFormat() {
    }

    public JsonFormat(List<E> data, int count, String code, String msg) {
        this.data = data;
        setCount(count);
        setMsg(msg);
        setCode(code);
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

}
