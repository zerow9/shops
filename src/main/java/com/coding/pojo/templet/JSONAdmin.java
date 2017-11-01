package com.coding.pojo.templet;

import com.coding.pojo.Admin;

import java.util.List;

/**
 *封装 Admin 为 JSON 对象
 */
public class JSONAdmin extends JSONTemplet {

    // 管理员列表
    private List<Admin>  data;

    public List<Admin> getData() {
        return data;
    }


    public void setData(List<Admin> data) {
        this.data = data;
    }
}
