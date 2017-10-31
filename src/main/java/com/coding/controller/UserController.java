package com.coding.controller;

import com.coding.Iservice.IUserService;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    /**
     * 插入一条用户信息(注册)
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertUser(User user) throws Exception {
        userService.insertUser(user);
        return "";
    }

    /**
     * 根据用户ID查询用户信息(登录)
     * @param userUuid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectUserByPrimaryKey(String userUuid) throws Exception {
        User user = userService.selectUserByPrimaryKey(userUuid);
        return "";
    }

    /**
     * 根据用户ID修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateUserByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateUserByPrimaryKey(User user) throws Exception {
        userService.updateUserByPrimaryKey(user);
        return "";
    }

    /**
     * 根据addressID删除地址信息
     * @param addressId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteAddressByPrimaryKey(Integer addressId) throws Exception {
        userService.deleteAddressByPrimaryKey(addressId);
        return "";
    }

    /**
     * 插入一条地址信息
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "insertAddress",method = {RequestMethod.GET,RequestMethod.POST})
    public String insertAddress(Address address,String uuid) throws Exception {
        address.setUserUuid(uuid);
        userService.insertAddress(address);
        return "";
    }

    /**
     * 查询用户地址
     * @param userUuid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectAddressByUserID",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressByUserID(String userUuid ) throws Exception {
        List<Address> address = userService.selectAddressByUserID(userUuid);
        return "";
    }

    /**
     * 根据用户ID更新地址信息
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateAddressByPrimaryKey",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddressByPrimaryKey(Address address,String userUuid) throws Exception {
        address.setUserUuid(userUuid);
        userService.updateAddressByPrimaryKey(address);
        return "";
    }

    /**
     * 查询所有信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectAddressAll",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectAddressAll() throws Exception {
        userService.selectAddressAll();
        return "";
    }

}
