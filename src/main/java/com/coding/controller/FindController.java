package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.paging.PagingCustomUser;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FindController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("admin/findUser")
    public String findUser(PagingCustomUser pagingCustomUser, HttpSession session) throws Exception {
        List<User> users = adminService.selectUser(pagingCustomUser);
        session.setAttribute("user",users.get(0));
        return "users/detailUser";
    }
}
