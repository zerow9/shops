package com.coding.mapper;

import com.coding.pojo.Order;

public interface OrderMapper {

    /**
     * 根据订单ID删除订单信息
     * @param orderId 订单ID
     * @return 是否删除成功 非0：成功  0:失败
     */
    int deleteOrderByPrimaryKey(Integer orderId);

    /**
     * 按需更新订单信息
     * @param order 封装了订单信息的 Order 类对象
     * @return 是否更新成功 非0：成功  0:失败
     */
    int updateOrderByPrimaryKeySelective(Order order);

    /**
     * 按需插入订单信息
     * @param order 封装了订单信息的 Order 类对象
     * @return 是否插入成功 非0：成功  0:失败
     */
    int insertOrderSelective(Order order);

    /**
     * 根据订单ID查询订单信息
     * @param orderId 订单ID
     * @return
     */
    Order selectByPrimaryKey(Integer orderId);



}