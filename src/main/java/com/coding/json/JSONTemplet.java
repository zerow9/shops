package com.coding.json;

import java.util.List;

/**
 * 转化给 json 的模板类
 */
public class JSONTemplet {

    //代码
    private String code;

    //信息
    private String msg;

    //数据条数
    private int count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
