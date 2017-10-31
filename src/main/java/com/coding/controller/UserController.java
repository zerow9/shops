package com.coding.controller;

import com.coding.Iservice.IUserService;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user) throws Exception {
        iUserService.insertUser(user);
        return "";
    }

    @RequestMapping(value = "selectUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserByPrimaryKey(String userUuid) throws Exception {
        User user = iUserService.selectUserByPrimaryKey(userUuid);
        return "";
    }
    @RequestMapping(value = "updateUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateUserByPrimaryKey(User user) throws Exception {
        iUserService.updateUserByPrimaryKey(user);
        return "";
    }
    @RequestMapping(value = "deleteAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAddressByPrimaryKey(Integer addressId) throws Exception {
        iUserService.deleteAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "insertAddress",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAddress(Address address) throws Exception {
        iUserService.insertAddress(address);
        return "";
    }
    @RequestMapping(value = "selectAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressByPrimaryKey(Integer addressId) throws Exception {
        Address address = iUserService.selectAddressByPrimaryKey(addressId);
        return "";
    }
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddressByPrimaryKey(Address address) throws Exception {
        iUserService.updateAddressByPrimaryKey(address);
        return "";
    }
    @RequestMapping(value = "selectAddressAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressAll() throws Exception {
        iUserService.selectAddressAll();
        return "";
    }

}
