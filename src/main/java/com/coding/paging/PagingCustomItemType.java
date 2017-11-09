package com.coding.paging;

import com.coding.pojo.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
public class PagingCustomItemType extends Paging {
    @Autowired
    private ItemType itemType;

    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    @Override
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
