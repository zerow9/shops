package com.coding.controller;

import com.coding.Iservice.UserService;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public void getItemTypes() throws Exception {
       // User user = new User();
       // user.setUserPhone("123456");
       // user.setUserPassword("123456");
       // userService.insertUser(user);
        System.out.println("OK");
    }
}