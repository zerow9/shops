package com.coding.mapper;

import com.coding.paging.PagingCustomCart;
import com.coding.pojo.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CartMapper {
    /**
     * 根据购物车ID删除购物车信息
     * @param cartId 购物车唯一ID
     * @return 是否删除成功 0:失败 非0:成功
     * @throws Exception
     */
    public int deleteCartByPrimaryKey(Integer cartId)throws Exception;

    /**
     * 根据购物车ID组批量删除购物车信息
     * @param cartIdArray 需要删除购物车ID组
     * @return 是否删除成功 0:失败 非0:成功
     * @throws Exception
     */
    public int deleteCartByPrimaryKeyArray(@Param("cartIdArray") Integer[] cartIdArray) throws Exception;

    /**
     * 插入完整购物车信息（包含所有购物车基本信息）
     * @param cart 封装了购物车信息的 Cart 类对象
     * @return 是否插入成功 0:失败 非0:成功
     * @throws Exception
     */
    public int insertCart(Cart cart)throws Exception;

    /**
     * 按需插入购物车信息（不必包含所有购物车基本信息，按需求添加）
     * @param cart 封装了购物车信息的 Cart 类对象
     * @return 是否插入成功 0:失败 非0:成功
     * @throws Exception
     */
    public int insertCartSelective(Cart cart)throws Exception;

    /**
     * 根据购物车唯一ID查询购物车信息
     * @param cartId 购物车唯一ID
     * @return 封装了满足查询条件的购物车 Cart 类对象
     * @throws Exception
     */
    public  Cart selectCartByPrimaryKey(Integer cartId)throws Exception;

    /**
     * 查询购物车表中一共有多少条信息
     * @return 购物车中一共有多少条数据
     * @throws Exception
     */
    public Integer selectCartCount()throws Exception;

    /**
     * 购物车查询功能集合
     * @param pagingCustomCart 基础查询类 Paging 的扩展类，封装了查询所需的所有条件
     * @return 封装了满足查询条件的购物车 Cart 类对象集合
     * @throws Exception
     */
    public List<Cart> selectCart(PagingCustomCart pagingCustomCart) throws Exception;

    /**
     * 根据购物车主键按需更新购物车信息（传入 Cart 对象只封装需更新数据）
     * @param cart 封装了购物车基本信息的 Cart 类对象
     * @return 是否更新成功 0:失败 非0:成功
     * @throws Exception
     */
    public int updateCartByPrimaryKeySelective(Cart cart)throws Exception;

    /**
     * 根据购物车主键更新购物车信息（传入 Cart 对象封装了需更新数据，不需要更新的数据也需要进行封装）
     * @param cart 封装了购物车基本信息的 Cart 类对象
     * @return 是否更新成功 0:失败 非0:成功
     * @throws Exception
     */
    public int updateCartByPrimaryKey(Cart cart)throws Exception;
}