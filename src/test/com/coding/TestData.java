package com.coding;

import com.coding.pojo.User;
import com.coding.pojo.templet.JSONUser;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static void main(String[] args){

        List<User> list=new ArrayList<User>();
        for (int i=0;i<5;i++){
            User user=new User();
            user.setUserName("zxx"+i);
            list.add(user);
        }

        JSONUser dataSourec=new JSONUser();
        dataSourec.setCode("TT");
        dataSourec.setCount(10);
        dataSourec.setMsg("");
        dataSourec.setData(list);

        JSONObject jsonObject=JSONObject.fromObject(dataSourec);
        System.out.println(jsonObject);

    }
}
