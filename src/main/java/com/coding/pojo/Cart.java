package com.coding.pojo;

import org.springframework.stereotype.Component;

@Component
public class Cart {
    private Integer cartId;

    private String userUuid;

    private Integer itemId;

    private String itemName;

    private Double price;

    private String itemImages;

    private Integer itemNumber;

    private Integer makeVender;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages == null ? null : itemImages.trim();
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getMakeVender() {
        return makeVender;
    }

    public void setMakeVender(Integer makeVender) {
        this.makeVender = makeVender;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userUuid='" + userUuid + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", itemImages='" + itemImages + '\'' +
                ", itemNumber=" + itemNumber +
                ", makeVender=" + makeVender +
                '}';
    }
}