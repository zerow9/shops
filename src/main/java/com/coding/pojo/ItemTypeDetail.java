package com.coding.pojo;

public class ItemTypeDetail extends ItemType{

    //商品分类的名称
    private String ParentItemTypeName;

    public String getParentItemTypeName() {
        return ParentItemTypeName;
    }

    public void setParentItemTypeName(String parentItemTypeName) {
        ParentItemTypeName = parentItemTypeName;
    }
}
