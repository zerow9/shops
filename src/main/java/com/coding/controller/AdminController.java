package com.coding.controller;

import com.coding.Iservice.IAdminServiceI;
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
    private IAdminServiceI adminService;

    @RequestMapping(value = "deleteUserByPrimaryKey", method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteUserByPrimaryKey(String userUuid) throws Exception {
        adminService.deleteUserByPrimaryKey(userUuid);
        return "";
    }

    @RequestMapping(value = "insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user) throws Exception {
        adminService.insertUser(user);
        return "";
    }

    @RequestMapping(value = "selectUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserByPrimaryKey(String userUuid) throws Exception {
        User user = adminService.selectUserByPrimaryKey(userUuid);
        return "";
    }

    @RequestMapping(value = "updateUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateUserByPrimaryKey(User user) throws Exception {
        adminService.updateUserByPrimaryKey(user);
        return "";
    }

    @RequestMapping(value = "selectUserAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserAll() throws Exception {
        List<User> users = adminService.selectUserAll();
        return "";
    }

    @RequestMapping(value = "deleteGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteGroupsByPrimaryKey(Integer groupId) throws Exception {
        adminService.deleteGroupsByPrimaryKey(groupId);
        return "";
    }
    @RequestMapping(value = "insertGroups",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertGroups(Groups group) throws Exception {
        adminService.insertGroups(group);
        return "";
    }
    @RequestMapping(value = "selectGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectGroupsByPrimaryKey(Integer groupId) throws Exception {
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        return "";
    }
    @RequestMapping(value = "updateGroupsByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateGroupsByPrimaryKey(Groups group) throws Exception {
        adminService.updateGroupsByPrimaryKey(group);
        return "";
    }
    @RequestMapping(value = "selectGroupAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectGroupAll() throws Exception {
        List<Groups> groupss= adminService.selectGroupsAll();
        return "";
    }


    @RequestMapping(value = "deleteAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        adminService.deleteAdminByPrimaryKey(adminId);
        return "";
    }
    @RequestMapping(value = "insertAdmin",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAdmin(Admin admin) throws Exception {
        adminService.insertAdmin(admin);
        return "";
    }
    @RequestMapping(value = "selectAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAdminByPrimaryKey(Integer adminId) throws Exception {
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        return "";
    }
    @RequestMapping(value = "updateAdminByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAdminByPrimaryKey(Admin admin) throws Exception {
        adminService.updateAdminByPrimaryKey(admin);
        return "";
    }
    @RequestMapping(value = "selectGroupAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAdminAll() throws Exception {
        List<Admin> admins = adminService.selectAdminAll();
        return "";
    }

    @RequestMapping(value = "deleteAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAddressByPrimaryKey(Integer addressId) throws Exception {
        adminService.deleteAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "insertAddress",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAddress(Address address) throws Exception {
        adminService.insertAddress(address);
        return "";
    }
    @RequestMapping(value = "selectAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressByPrimaryKey(Integer addressId) throws Exception {
        Address address = adminService.selectAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddressByPrimaryKey(Address address) throws Exception {
        adminService.updateAddressByPrimaryKey(address);
        return "";
    }
    @RequestMapping(value = "selectAddressAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressAll() throws Exception {
        List<Address> addresses = adminService.selectAddressAll();
        return "";
    }








}
