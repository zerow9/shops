package com.coding.mapper;

import com.coding.pojo.ItemType;

import java.util.List;

public interface ItemTypeMapper {

    public void deleteItemTypeByPrimaryKey(Integer itemTypeId);

    public void  insertItemType(ItemType itemType);

    public ItemType selectItemTypeByPrimaryKey(Integer itemTypeId);

    public void updateItemTypeByPrimaryKey(ItemType itemType);

    public List<ItemType> selectItemTypeAll();
}