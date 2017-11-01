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
    public int deleteItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 增加商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public int insertItem(Item item) throws Exception;

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
    public int updateItemByPrimaryKey(Item item) throws Exception;

    /**
     * 根据商品名称模糊查找商品信息
     *
     * @param  fuzzyItemName 商品名称
     * @return 通过正则表达式满足模糊匹配的商品信息
     */
    public List<Item> selectItemFuzzyByItemName(@Param("fuzzyItemName") String fuzzyItemName)throws Exception;

    /**
     * 根据商品类别查找商品信息
     * @param itemTypeId 商品类别ID
     * @return 满足查询条件的 Item 类对象集合
     * @throws Exception
     */
    public List<Item> selectItemByItemType(@Param("itemTypeId") Integer itemTypeId)throws Exception;


}