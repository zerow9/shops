package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.JavaGet;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomItem;
import com.coding.paging.PagingCustomLog;
import com.coding.paging.PagingCustomUser;
import com.coding.pojo.Item;
import com.coding.pojo.Log;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        if (page == 1)
            count = adminService.selectUser(pagingCustomUser).size();
        pagingCustomUser.addIndex(page, limit);
        List<User> users = adminService.selectUser(pagingCustomUser);
        MyJsonConfig<User> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(users, count);
    }

    @RequestMapping("item/findItem")
    @ResponseBody
    public String findItem(HttpServletRequest request, PagingCustomItem pagingCustomItem, Integer page, Integer limit) throws Exception {
        String name = JavaGet.charsetGet(pagingCustomItem.getItem().getItemName(), request);
        String word = JavaGet.charsetGet(pagingCustomItem.getItem().getKeyWord(), request);
        pagingCustomItem.getItem().setItemName(name);
        pagingCustomItem.getItem().setKeyWord(word);
        if (page == 1)
            count = adminService.selectItem(pagingCustomItem).size();
        pagingCustomItem.addIndex(page, limit);
        List<Item> items = adminService.selectItem(pagingCustomItem);
        MyJsonConfig<Item> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(items, count);
    }

    @RequestMapping("log/findLogs")
    @ResponseBody
    public String findLogs(PagingCustomLog pagingCustomLog, Integer page, Integer limit) throws Exception {
        if (page == 1)
            count = adminService.selectLog(pagingCustomLog).size();
        pagingCustomLog.addIndex(page, limit);
        List<Log> logs = adminService.selectLog(pagingCustomLog);
        MyJsonConfig myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(logs, count);
    }
}