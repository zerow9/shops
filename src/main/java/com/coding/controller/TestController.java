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

    // 商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("insertuser")
    public void getItemTypes() throws Exception {
        User user = new User();
        user.setUserPhone("123456");
        user.setUserPassword("123456");
        userService.insertUser(user);
        System.out.println("OK");
    }
}