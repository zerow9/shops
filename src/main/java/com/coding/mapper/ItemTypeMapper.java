package com.coding.mapper;

import com.coding.pojo.ItemType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemTypeMapper {
    /**
     * 根据商品类别ID删除商品类别信息
     *
     * @param itemTypeId 商品类别ID
     * @throws Exception
     */
    public int deleteItemTypeByPrimaryKey(Integer itemTypeId) throws Exception;

    /**
     * 增加商品类别信息
     *
     * @param itemType 商品类别
     * @throws Exception
     */
    public int insertItemType(ItemType itemType) throws Exception;

    /**
     * 通过上类品类别ID查询商品类别信息
     * @param itemTypeId 商品类别ID
     * @return 封装了商品类别信息的 ItemType 类对象
     * @throws Exception
     */

    public ItemType selectItemTypeByPrimaryKey(@Param("itemTypeId") Integer itemTypeId) throws Exception;

    /**
     * 通过商品类别ID更新商品类别信息
     * @param itemType 封装了商品类别信息的 ItemType 类对象
     * @throws Exception
     */
    public int updateItemTypeByPrimaryKey(ItemType itemType) throws Exception;

    /**
     * 查询所有商品类别信息
     * @return 封装了商品类别信息的 ItemType 类对象集合
     * @throws Exception
     */
    public List<ItemType> selectItemTypeAll() throws Exception;
}