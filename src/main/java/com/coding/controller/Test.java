package com.coding.controller;

import com.coding.mapper.AddressMapper;
import com.coding.mapper.AdminMapper;
import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
@Controller
public class Test {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("test")
    public void selectAdminAll(){
        System.out.println("Controller~~~");
        List<Admin> adminList = adminMapper.selectAdminAll();
        System.out.println(adminList);
    }

    @RequestMapping("test1")
    public void insertAdmin(){
        System.out.println("Controller~~~");
        Admin admin = new Admin();

        admin.setAdminAccount("2");
        admin.setAdminEmail("2");
        admin.setAdminPassword("2");
        admin.setAdminPhone("2");
        admin.setAdminRegisterTime(new Date());
        admin.setGroupId(2);
        System.out.println(admin);
        adminMapper.insertAdmin(admin);
    }

    @RequestMapping("test3")
    public void deleteAdminByPrimaryKey(){
        System.out.println("Controller~~~");
        adminMapper.deleteAdminByPrimaryKey(2);
    }

    @RequestMapping("test4")
    public void selectAdminByPrimaryKey(){
        System.out.println("Controller~~~");
        Admin admin = adminMapper.selectAdminByPrimaryKey(2);
        System.out.println(admin);
    }

    @RequestMapping("test5")
    public void updateAdminByPrimaryKey(){
        System.out.println("Controller~~~");

        Admin admin = new Admin();
        admin.setAdminId(2);
        admin.setAdminAccount("3");
        admin.setAdminEmail("3");
        admin.setAdminPassword("3");
        admin.setAdminPhone("3");
        admin.setAdminRegisterTime(new Date());
        admin.setGroupId(2);
        adminMapper.updateAdminByPrimaryKey(admin);
        System.out.println(admin);
    }

}
