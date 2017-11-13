package com.coding.paging;

import com.coding.pojo.ItemType;
public class PagingCustomItemType extends Paging {
    private ItemType itemType;

    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    public String toString() {
        return "PagingCustomItemType{" +
                "itemType=" + itemType +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
