package com.coding.mapper;

import com.coding.pojo.Order;
import com.coding.pojo.PagingCustomOrder;
import org.apache.ibatis.annotations.Param;
import sun.org.mozilla.javascript.internal.EcmaError;

import java.util.List;

public interface OrderMapper {

    /**
     * 根据订单ID删除订单信息
     * @param orderId 订单ID
     * @return 是否删除成功 非0：成功  0:失败
     */
    public int deleteOrderByPrimaryKey(Integer orderId)throws Exception;

    /**
     * 批量删除订单信息
     * @param orderIdArray 待删除订单ID数组
     * @return 是否删除成功   非0:成功   0:失败
     * @throws Exception
     */
    public int deleteOrderByPrimaryKeyArray(@Param("orderIdArray") Integer[] orderIdArray)throws Exception;

    /**
     * 按需更新订单信息
     * @param order 封装了订单信息的 Order 类对象
     * @return 是否更新成功 非0：成功  0:失败
     */
    public int updateOrderByPrimaryKeySelective(Order order)throws Exception;

    /**
     * 按需插入订单信息
     * @param order 封装了订单信息的 Order 类对象
     * @return 是否插入成功 非0：成功  0:失败
     */
    public int insertOrderSelective(Order order)throws Exception;

    /**
     * 根据订单ID查询订单信息
     * @param pagingCustomOrder 封装了 order、查询信息 的 PagingCustomOrder 类对象
     * @return 符合查询条件的 Order 类对象
     */
    public Order selectOrderByPrimaryKey(PagingCustomOrder pagingCustomOrder)throws Exception;

    /**
     * 订单表查询功能大集合（传入的时间类型都需要改为 String 类型的）
     *
     * @param pagingCustomOrder
     * @return
     * @throws Exception
     */
    public List<Order> selectOrder(PagingCustomOrder pagingCustomOrder)throws Exception;

    /**
     * 查询商品表中共有多少数据
     * @return 返回商品表中共有多少数据
     * @throws Exception
     */
    public Integer selectOrderCount()throws Exception;
}