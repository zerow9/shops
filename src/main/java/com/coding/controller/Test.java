package com.coding.controller;

import com.coding.mapper.GroupsMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class Test {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("test1")
    public void insertUser() {
        User user = new User();
        user.setUserAddress(1);
        user.setUserAge(1);
        user.setUserCurrentTime(new Date());
        user.setUserEmail("1");
        user.setUserGroup(1);
        user.setUserHealthy("1");
        user.setUserLandIp("1");
        user.setUserLandNumber(1);
        user.setUserName("1");
        user.setUserNickname("1");
        user.setUserPassword("1");
        user.setUserPhone("1");
        user.setUserRegisterDateTime(new Date());
        user.setUserScore(1);
        user.setUserSex("1");
        user.setUserUuid("1");
        userMapper.insertUser(user);
    }
    @RequestMapping("test2")
    public void selectUserByPrimaryKey(){
        User user = userMapper.selectUserByPrimaryKey("2");
        System.out.println(user);
    }

    @RequestMapping("test3")
    public void updateUserByPrimaryKey(){
        User user = new User();
        user.setUserAddress(1);
        user.setUserAge(1);
        user.setUserCurrentTime(new Date());
        user.setUserEmail("1");
        user.setUserGroup(1);
        user.setUserHealthy("1");
        user.setUserLandIp("1");
        user.setUserLandNumber(1);
        user.setUserName("1");
        user.setUserNickname("2s");
        user.setUserPassword("2");
        user.setUserPhone("1");
        user.setUserRegisterDateTime(new Date());
        user.setUserScore(1);
        user.setUserSex("1");
        user.setUserUuid("1");
        userMapper.updateUserByPrimaryKey(user);
        System.out.println(user);
    }


    @RequestMapping("test4")
    public void selectUserAll(){
        List<User> userList = userMapper.selectUserAll();
        System.out.println(userList);
    }
}
