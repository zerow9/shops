package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.Iservice.IindexItemService;
import com.coding.Lucene.SearchField;
import com.coding.comomInterface.JavaGet;
import com.coding.json.MyJsonConfig;
import com.coding.paging.*;
import com.coding.pojo.*;
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
    @Autowired
    private IindexItemService indexItemService;
    private Integer counts;


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

    @RequestMapping("repertories/findRepertory")
    @ResponseBody
    public String findRepertory(PagingCustomRepertory pagingCustomRepertory, Integer page, Integer limit) throws Exception {
        if (page == 1)
            count = adminService.selectRepertory(pagingCustomRepertory).size();
        pagingCustomRepertory.addIndex(page, limit);
        List<Repertory> repertories = adminService.selectRepertory(pagingCustomRepertory);
        MyJsonConfig myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(repertories, count);
    }

    @RequestMapping("venders/findVender")
    @ResponseBody
    public String findVenders(HttpServletRequest request, Vender vender, Integer page, Integer limit) throws Exception {
        String name = JavaGet.charsetGet(vender.getVenderName(), request);
        String address = JavaGet.charsetGet(vender.getVenderAddress(), request);
        vender.setVenderName(name);
        vender.setVenderAddress(address);
        PagingCustomVender pagingCustomVender = new PagingCustomVender();
        pagingCustomVender.setVender(vender);
        if (page == 1)
            count = adminService.selectVender(pagingCustomVender).size();
        pagingCustomVender.addIndex(page, limit);
        List<Vender> venders = adminService.selectVender(pagingCustomVender);
        MyJsonConfig<Vender> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(venders, count);
    }

    @RequestMapping("complaint/findComplaints")
    @ResponseBody
    public String findComplaints(HttpServletRequest request, PagingCustomComplaint complaint, Integer page, Integer limit) throws Exception {
        String title = JavaGet.charsetGet(complaint.getComplaint().getComplaintTittle(), request);
        complaint.getComplaint().setComplaintTittle(title);
        if (page == 1)
            count = adminService.selectComplaint(complaint).size();
        complaint.addIndex(page, limit);
        List<Complaint> complaints = adminService.selectComplaint(complaint);
        MyJsonConfig<Complaint> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(complaints, count);
    }
    @RequestMapping("index/findIndex")
    public String findIndex(String searchKey,Integer page, Integer limit,HttpServletRequest request)throws Exception{
        SearchField searchField = new SearchField();
        searchField.setCondition(searchKey);
        searchField.setPageNumber(limit);
        searchField.setIndexNumber((page - 1) * limit);
        if (page == 1)
            counts = indexItemService.getDocCount(searchField);
        List<Item> items = indexItemService.findIndexAll(searchField);
        MyJsonConfig<Item> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(items, counts);
    }

}