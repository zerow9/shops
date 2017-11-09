package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.Iservice.IUserService;
import com.coding.comomInterface.DateToString;
import com.coding.json.JsonFormat;
import com.coding.json.MyJsonConfig;
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
        MyJsonConfig<Orders> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(orders, counts);
    }

    @ResponseBody
    @RequestMapping("selectOrderByPrimaryKey")
    public String selectOrderByPrimaryKey(String orderId) {
        try {
            Orders orders = userService.selectOrderByPrimaryKey(Integer.parseInt(orderId));
            JSONObject jsonObject = JSONObject.fromObject(orders);
            return jsonObject.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
