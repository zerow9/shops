package com.coding.mapper;

import com.coding.pojo.ItemType;

import java.util.List;

public interface ItemTypeMapper {

    public void deleteItemTypeByPrimaryKey(Integer itemTypeId) throws Exception;

    public void  insertItemType(ItemType itemType) throws Exception;

    public ItemType selectItemTypeByPrimaryKey(Integer itemTypeId) throws Exception;

    public void updateItemTypeByPrimaryKey(ItemType itemType) throws Exception;

    public List<ItemType> selectItemTypeAll() throws Exception;
}