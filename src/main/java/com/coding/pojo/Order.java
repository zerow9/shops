package com.coding.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String userUuid;

    private Integer shopId;

    private String takeGoodsName;

    private String takeGoodsPhone;

    private Integer takeGoodsPost;

    private Double orderSumPrice;

    private Integer useScore;

    private Integer sendScore;

    private Integer payStatus;

    private Integer sendStatus;

    private Integer discussStatus;

    private Integer protectStatus;

    private Integer payType;

    private Date orderCreateTime;

    private Date orderPayTime;

    private Double orderPaid;

    private Double orderRefund;

    private String sendWay;

    private Integer addressId;

    private String buyMessage;

    private String takeGoodsProvince;

    private String takeGoodsCity;

    private String takeGoodsCounty;

    private Date sendGoodsTime;

    private Double orderFreight;

    private Date orderCompletionTime;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getTakeGoodsName() {
        return takeGoodsName;
    }

    public void setTakeGoodsName(String takeGoodsName) {
        this.takeGoodsName = takeGoodsName == null ? null : takeGoodsName.trim();
    }

    public String getTakeGoodsPhone() {
        return takeGoodsPhone;
    }

    public void setTakeGoodsPhone(String takeGoodsPhone) {
        this.takeGoodsPhone = takeGoodsPhone == null ? null : takeGoodsPhone.trim();
    }

    public Integer getTakeGoodsPost() {
        return takeGoodsPost;
    }

    public void setTakeGoodsPost(Integer takeGoodsPost) {
        this.takeGoodsPost = takeGoodsPost;
    }

    public Double getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(Double orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
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

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getDiscussStatus() {
        return discussStatus;
    }

    public void setDiscussStatus(Integer discussStatus) {
        this.discussStatus = discussStatus;
    }

    public Integer getProtectStatus() {
        return protectStatus;
    }

    public void setProtectStatus(Integer protectStatus) {
        this.protectStatus = protectStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Double getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(Double orderPaid) {
        this.orderPaid = orderPaid;
    }

    public Double getOrderRefund() {
        return orderRefund;
    }

    public void setOrderRefund(Double orderRefund) {
        this.orderRefund = orderRefund;
    }

    public String getSendWay() {
        return sendWay;
    }

    public void setSendWay(String sendWay) {
        this.sendWay = sendWay == null ? null : sendWay.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuyMessage() {
        return buyMessage;
    }

    public void setBuyMessage(String buyMessage) {
        this.buyMessage = buyMessage == null ? null : buyMessage.trim();
    }

    public String getTakeGoodsProvince() {
        return takeGoodsProvince;
    }

    public void setTakeGoodsProvince(String takeGoodsProvince) {
        this.takeGoodsProvince = takeGoodsProvince == null ? null : takeGoodsProvince.trim();
    }

    public String getTakeGoodsCity() {
        return takeGoodsCity;
    }

    public void setTakeGoodsCity(String takeGoodsCity) {
        this.takeGoodsCity = takeGoodsCity == null ? null : takeGoodsCity.trim();
    }

    public String getTakeGoodsCounty() {
        return takeGoodsCounty;
    }

    public void setTakeGoodsCounty(String takeGoodsCounty) {
        this.takeGoodsCounty = takeGoodsCounty == null ? null : takeGoodsCounty.trim();
    }

    public Date getSendGoodsTime() {
        return sendGoodsTime;
    }

    public void setSendGoodsTime(Date sendGoodsTime) {
        this.sendGoodsTime = sendGoodsTime;
    }

    public Double getOrderFreight() {
        return orderFreight;
    }

    public void setOrderFreight(Double orderFreight) {
        this.orderFreight = orderFreight;
    }

    public Date getOrderCompletionTime() {
        return orderCompletionTime;
    }

    public void setOrderCompletionTime(Date orderCompletionTime) {
        this.orderCompletionTime = orderCompletionTime;
    }

}