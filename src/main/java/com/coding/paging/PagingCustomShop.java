package com.coding.paging;

import com.coding.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;

public class PagingCustomShop extends Paging {
    @Autowired
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "PagingCustomShop{" +
                "shop=" + shop +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
