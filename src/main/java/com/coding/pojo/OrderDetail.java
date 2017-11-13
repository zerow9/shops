package com.coding.pojo;


public class OrderDetail {
    private Integer orderDetailId;

    private Integer orderId;

    private Integer itemId;

    private Double itemPrice;

    private Integer itemNumber;

    private Double itemSumPrice;

    private Integer useScore;

    private Integer sendScore;

    private String userUuid;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Double getItemSumPrice() {
        return itemSumPrice;
    }

    public void setItemSumPrice(Double itemSumPrice) {
        this.itemSumPrice = itemSumPrice;
    }

    public Integer getUseScore() {
        return useScore;
    }

    public void setUseScore(Integer useScore) {
        this.useScore = useScore;
    }

    public Integer getSendScore() {
        return sendScore;
    }

    public void setSendScore(Integer sendScore) {
        this.sendScore = sendScore;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid ;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", itemPrice=" + itemPrice +
                ", itemNumber=" + itemNumber +
                ", itemSumPrice=" + itemSumPrice +
                ", useScore=" + useScore +
                ", sendScore=" + sendScore +
                ", userUuid='" + userUuid + '\'' +
                '}';
    }
}