package com.coding.pojo.templet;

import com.coding.pojo.User;

import java.util.List;

//封装 User 为 JSON 对象
public class JSONUser extends JSONTemplet{

    //User 列表
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JSONUser{" +
                "data=" + data +
                '}';
    }
}
