package com.coding.pojo;


public class Shop {
    private Integer shopId;

    private String shopAddress;

    private String shopName;

    private Double shopX;

    private Double shopY;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Double getShopX() {
        return shopX;
    }

    public void setShopX(Double shopX) {
        this.shopX = shopX;
    }

    public Double getShopY() {
        return shopY;
    }

    public void setShopY(Double shopY) {
        this.shopY = shopY;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopX=" + shopX +
                ", shopY=" + shopY +
                '}';
    }
}