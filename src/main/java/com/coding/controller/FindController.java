package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.JavaGet;
import com.coding.json.MyJsonConfig;
import com.coding.mapper.UserMapper;
import com.coding.paging.PagingCustomUser;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FindController {

    private Integer count = null;

    @Autowired
    private IAdminService adminService;


    @RequestMapping("admin/findUser")
    @ResponseBody
    public String findUser(HttpServletRequest request, PagingCustomUser pagingCustomUser, Integer page, Integer limit) throws Exception {
        String sex = JavaGet.charsetGet(pagingCustomUser.getUser().getUserSex(), request);
        String name = JavaGet.charsetGet(pagingCustomUser.getUser().getUserName(), request);
        pagingCustomUser.getUser().setUserSex(sex);
        pagingCustomUser.getUser().setUserName(name);
        System.out.println(pagingCustomUser.getUser().getUserUuid() );
        if (count == null || page == 1)
            count = adminService.selectUser(pagingCustomUser).size();
        pagingCustomUser.addIndex(page, limit);
        List<User> users = adminService.selectUser(pagingCustomUser);
        MyJsonConfig<User> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(users, count);
    }
}
