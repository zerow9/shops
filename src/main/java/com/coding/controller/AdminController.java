package com.coding.controller;

import com.coding.Iservice.AdminService;
import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "deleteUserByPrimaryKey", method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteUserByPrimaryKey(String userUuid){
        adminService.deleteUserByPrimaryKey(userUuid);
        return "";
    }

    @RequestMapping(value = "insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user){
        adminService.insertUser(user);
        return "";
    }

    @RequestMapping(value = "selectUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserByPrimaryKey(String userUuid){
        User user = adminService.selectUserByPrimaryKey(userUuid);
        return "";
    }

    @RequestMapping(value = "updateUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateUserByPrimaryKey(User user){
        adminService.updateUserByPrimaryKey(user);
        return "";
    }

    @RequestMapping(value = "selectUserAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserAll(){
        List<User> users = adminService.selectUserAll();
        return "";
    }

    @RequestMapping(value = "deleteGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteGroupsByPrimaryKey(Integer groupId){
        adminService.deleteGroupsByPrimaryKey(groupId);
        return "";
    }
    @RequestMapping(value = "insertGroups",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertGroups(Groups group){
        adminService.insertGroups(group);
        return "";
    }
    @RequestMapping(value = "selectGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectGroupsByPrimaryKey(Integer groupId){
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        return "";
    }
    @RequestMapping(value = "updateGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateGroupsByPrimaryKey(Groups group){
        adminService.updateGroupsByPrimaryKey(group);
        return "";
    }
    @RequestMapping(value = "selectGroupAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectGroupAll(){
        List<Groups> groupss= adminService.selectGroupsAll();
        return "";
    }


    @RequestMapping(value = "deleteAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAdminByPrimaryKey(Integer adminId){
        adminService.deleteAdminByPrimaryKey(adminId);
        return "";
    }
    @RequestMapping(value = "insertAdmin",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAdmin(Admin admin){
        adminService.insertAdmin(admin);
        return "";
    }
    @RequestMapping(value = "selectAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAdminByPrimaryKey(Integer adminId){
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        return "";
    }
    @RequestMapping(value = "updateAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAdminByPrimaryKey(Admin admin){
        adminService.updateAdminByPrimaryKey(admin);
        return "";
    }
    @RequestMapping(value = "selectGroupAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAdminAll(){
        List<Admin> admins = adminService.selectAdminAll();
        return "";
    }

    @RequestMapping(value = "deleteAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAddressByPrimaryKey(Integer addressId){
        adminService.deleteAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "insertAddress",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAddress(Address address){
        adminService.insertAddress(address);
        return "";
    }
    @RequestMapping(value = "selectAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressByPrimaryKey(Integer addressId){
        Address address = adminService.selectAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddressByPrimaryKey(Address address){
        adminService.updateAddressByPrimaryKey(address);
        return "";
    }
    @RequestMapping(value = "selectAddressAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressAll(){
        List<Address> addresses = adminService.selectAddressAll();
        return "";
    }








}
