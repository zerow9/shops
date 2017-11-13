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
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "order", produces = {"application/json;charset=UTF-8"})
public class OrderController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    private Integer count = null;

    /**
     * 订单列表页
     *
     * @return 订单列表jsp页面
     */
    @RequestMapping("orderList")
    public String orderList() {
        return "order/order_list";
    }

    /**
     * 查询所有订单信息
     *
     * @param page limit
     * @return json
     * json 封装了信息（msg）和数据（data），如果请求数据正常，msg值为true，否则msg为出错的信息描述
     */
    @ResponseBody
    @RequestMapping("selectOrder")
    public String selectOrder(Integer page, Integer limit, HttpSession session, String formDate) throws Exception {
        System.out.println("表单数据：" + formDate);
        PagingCustomOrder pagingCustomOrder = new PagingCustomOrder();
        if (formDate != null) {
            Orders ordersForm = new Orders();
            JSONObject jsonObject = JSONObject.fromObject(formDate);
            if (!jsonObject.getString("orderId").equals(""))
                ordersForm.setOrderId(Integer.parseInt(jsonObject.getString("orderId")));
            if (!jsonObject.getString("payStatus").equals(""))
                ordersForm.setPayStatus(Integer.parseInt(jsonObject.getString("payStatus")));
            if (!jsonObject.getString("sendStatus").equals(""))
                ordersForm.setSendStatus(Integer.parseInt(jsonObject.getString("sendStatus")));
            if (!jsonObject.getString("takeGoodsName").equals(""))
                ordersForm.setTakeGoodsName(jsonObject.getString("takeGoodsName"));
            pagingCustomOrder.setOrder(ordersForm);
        }
        pagingCustomOrder.addIndex(page, limit);
        if (count == null)
            count = adminService.selectOrderCount();
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        try {
            List<Orders> orders = userService.selectOrder(pagingCustomOrder);
            return myJsonConfig.start(orders, count, "true");
        } catch (Exception e) {
            return myJsonConfig.start(new ArrayList(), count, session.getAttribute("message").toString());
        }

    }

    /**
     * 查询订单详细信息
     *
     * @param orderId
     * @return json
     * json 封装了信息（msg）和数据（data），如果请求数据正常，msg值为true，否则msg为出错的信息描述
     */
    @ResponseBody
    @RequestMapping("selectOrderByPrimaryKey")
    public String selectOrderByPrimaryKey(String orderId) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Orders orders = userService.selectOrderByPrimaryKey(Integer.parseInt(orderId));
            orders.setOrderCreateTimeToString(DateToString.date(orders.getOrderCreateTime()));
            JSONObject jsonObject = JSONObject.fromObject(orders);
            resultMap.put("msg", "true");
            resultMap.put("order", jsonObject);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
        }
        return JSONObject.fromObject(resultMap).toString();
    }

    /**
     * 删除单个订单
     *
     * @param orderId
     * @return json
     * json 封装了信息（msg），如果请求数据正常，msg值为true，否则msg为出错的信息描述
     */
    @ResponseBody
    @RequestMapping("deleteOrderByPrimaryKey")
    public String deleteOrderByPrimaryKey(String orderId) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            userService.deleteOrderByPrimaryKey(Integer.parseInt(orderId));
            resultMap.put("msg", "true");
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
        }
        count--;
        return JSONObject.fromObject(resultMap).toString();
    }

    /**
     * 批量删除订单
     *
     * @param orderId
     * @return json
     * json 封装了信息（msg），如果请求数据正常，msg值为true，否则msg为出错的信息描述
     */
    @ResponseBody
    @RequestMapping("deleteOrderByPrimaryKeyArray")
    public String deleteOrderByPrimaryKeyArray(String orderId) {
        String[] orderIds = orderId.split(",");
        Map<String, Object> resultMap = new HashMap<>();
        Integer[] orderId_int = new Integer[orderIds.length];
        int i = 0;
        for (String each : orderIds) {
            orderId_int[i] = Integer.parseInt(each);
            i++;
        }
        try {
            userService.deleteOrderByPrimaryKeyArray(orderId_int);
            resultMap.put("msg", "true");
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
        }
        count -= i;
        return JSONObject.fromObject(resultMap).toString();
    }
}
