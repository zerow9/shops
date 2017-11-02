package com.coding.controller;

import com.coding.Iservice.IUserService;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    /**
     * 插入一条用户信息(注册)
     *
     * @param user 新用户
     */
    @RequestMapping("insertUser")
    public boolean insertUser(User user) throws Exception {
        user.setUserRegisterDateTime(new Date());
        userService.insertUser(user);
        return true;
    }

    /**
     * 根据用户ID查询用户信息(登录)
     *
     * @param userUuid 用户的uuid
     */
    @RequestMapping("selectUserByPrimaryKey")
    public String selectUserByPrimaryKey(String userUuid) throws Exception {
        User user = userService.selectUserByPrimaryKey(userUuid);
        return "";
    }

    /**
     * 根据用户ID修改用户信息
     *
     * @param user 更新用户的信息
     */
    @RequestMapping("updateUserByPrimaryKey")
    public String updateUserByPrimaryKey(User user) throws Exception {
        userService.updateUserByPrimaryKey(user);
        return "";
    }

    /**
     * 根据addressID删除地址信息
     *
     * @param addressId 地址id
     */
    @RequestMapping("deleteAddressByPrimaryKey")
    public String deleteAddressByPrimaryKey(Integer addressId) throws Exception {
        userService.deleteAddressByPrimaryKey(addressId);
        return "";
    }

    /**
     * 插入一条地址信息
     *
     * @param address 用户的收货地址
     * @param uuid    用户的uuid
     */
    @RequestMapping("insertAddress")
    public String insertAddress(Address address, String uuid) throws Exception {
        address.setUserUuid(uuid);
        userService.insertAddress(address);
        return "";
    }

    /**
     * 查询用户地址
     *
     * @param userUuid 根据用户uuid查询用户地址
     */
    @RequestMapping("selectAddressByUserID")
    public String selectAddressByUserID(String userUuid) throws Exception {
        List<Address> address = userService.selectAddressByUserID(userUuid);
        return "";
    }

    /**
     * 根据用户ID更新地址信息
     *
     * @param address  更新地址信息
     * @param userUuid 根据用户的uuid来更新地址
     */
    @RequestMapping("updateAddressByPrimaryKey")
    public String updateAddressByPrimaryKey(Address address, String userUuid) throws Exception {
        address.setUserUuid(userUuid);
        userService.updateAddressByPrimaryKey(address);
        return "";
    }


    @RequestMapping("addUser")
    public String addUser() {
        return "users/adduser";
    }
}
