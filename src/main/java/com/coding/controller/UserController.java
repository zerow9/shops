package com.coding.controller;

import com.coding.Iservice.UserService;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user){
        userService.insertUser(user);
        return "";
    }

    @RequestMapping(value = "selectUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserByPrimaryKey(String userUuid){
        User user = userService.selectUserByPrimaryKey(userUuid);
        return "";
    }
    @RequestMapping(value = "updateUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateUserByPrimaryKey(User user){
        userService.updateUserByPrimaryKey(user);
        return "";
    }
    @RequestMapping(value = "deleteAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAddressByPrimaryKey(Integer addressId){
        userService.deleteAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "insertAddress",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAddress(Address address){
        userService.insertAddress(address);
        return "";
    }
    @RequestMapping(value = "selectAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressByPrimaryKey(Integer addressId){
        Address address = userService.selectAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddressByPrimaryKey(Address address){
        userService.updateAddressByPrimaryKey(address);
        return "";
    }
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressAll(){
        userService.selectAddressAll();
        return "";
    }




}
