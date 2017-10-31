package com.coding.mapper;

import com.coding.pojo.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {

    /**
     * 根据商品ID删除商品信息
     *
     * @param itemId 商品唯一ID
     */
    public void deleteItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 增加商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public void insertItem(Item item) throws Exception;

    /**
     * 根据商品唯一ID查询商品信息
     *
     * @param itemId 商品唯一ID
     * @return 封装了商品信息的 Item 类对象
     */
    public Item selectItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 查询所有商品信息
     *
     * @return 封装了商品信息的 Item 类对象
     */
    public List<Item> selectItemAll() throws Exception;


    /**
     * 根据商品唯一ID更新商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public void updateItemByPrimaryKey(Item item) throws Exception;
}