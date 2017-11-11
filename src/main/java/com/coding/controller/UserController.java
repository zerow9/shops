package com.coding.controller;

import com.coding.Iservice.IUserService;
import com.coding.comomInterface.DateToString;
import com.coding.comomInterface.MyUUID;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping("insertUser")
    public boolean insertUser(User user) throws Exception {
        System.out.println(user);
        user.setUserRegisterDateTime(new Date());
        user.setUserAge(11);
        user.setUserLandNumber(11);
        user.setUserCurrentTime(new Date());
        user.setUserLandIp(InetAddress.getLocalHost().getHostAddress());
        user.setUserUuid(MyUUID.randomUUID());
        user.setUserAddress(1);
        userService.insertUser(user);
        return true;
    }

    @RequestMapping("addUser")
    public String addUser() {
        return "users/adduser";
    }

}
