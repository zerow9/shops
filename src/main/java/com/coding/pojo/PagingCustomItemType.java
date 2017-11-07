package com.coding.pojo;

import org.springframework.stereotype.Component;

@Component
public class PagingCustomItemType extends Paging {
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
