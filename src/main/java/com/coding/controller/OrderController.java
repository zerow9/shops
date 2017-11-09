package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.Iservice.IUserService;
import com.coding.comomInterface.DateToString;
import com.coding.json.JsonFormat;
import com.coding.pojo.Address;
import com.coding.pojo.Orders;
import com.coding.paging.PagingCustomOrder;
import com.coding.pojo.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    private Integer counts = null;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @RequestMapping("orderList")
    public String orderList() {
        return "order/order_list";
    }

    @ResponseBody
    @RequestMapping("selectOrder")
    public String selectOrder(Integer page, Integer limit) throws Exception {
        PagingCustomOrder pagingCustomOrder = new PagingCustomOrder();
        pagingCustomOrder.setPageNumber(limit);
        pagingCustomOrder.setIndexNumber((page - 1) * limit);
        if (counts == null)
            counts = adminService.selectOrderCount();
        List<Orders> orders = userService.selectOrder(pagingCustomOrder);
        JsonFormat<Orders> json = new JsonFormat<>(orders, counts, null, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
    }

    /**
     * 插入一条用户信息(注册)
     *
     * @param user 新用户
     */
//    @RequestMapping("insertUser")
//    public boolean insertUser(User user) throws Exception {
//        System.out.println(user);
//        user.setUserRegisterDateTime(new Date());
//        user.setUserAge(11);
//        user.setUserLandNumber(11);
//        user.setUserCurrentTime(new Date());
//        user.setUserLandIp(InetAddress.getLocalHost().getHostAddress());
//        user.setUserUuid(MyUUID.randomUUID());
//        user.setUserAddress(1);
//        userService.insertUser(user);
//        return true;
//    }

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
     * @param userUuid 更新用户的信息
     */


    /**
     * 根据orderId删除订单信息
     *
     * @param orderId 订单编号
     */
    @RequestMapping("deleteOrderByPrimaryKey")
    public String deleteOrderByPrimaryKey(Integer orderId) throws Exception {
        userService.deleteAddressByPrimaryKey(orderId);
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


    @RequestMapping("seeUserIdByKey")
    public String seeUserIdByKey(String userUuid, Model model) throws Exception {
        User user = userService.selectUserByPrimaryKey(userUuid);
        user.setDateToString(DateToString.date(user.getUserRegisterDateTime()));
        model.addAttribute("user", user);
        return "users/seeUser";
    }
}
