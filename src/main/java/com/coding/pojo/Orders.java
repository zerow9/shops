package com.coding.pojo;

import com.coding.converter.DateFormatTool;
import com.coding.json.JsonFormat;

import java.util.Date;

public class Orders {

    private DateFormatTool dateFormatTool = new DateFormatTool();

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
    private String orderCreateTimeToString;

    private Date orderPayTime;
    private String orderPayTimeToString;

    private Double orderPaid;

    private Double orderRefund;

    private String sendWay;

    private Integer addressId;

    private String buyMessage;

    private String takeGoodsProvince;

    private String takeGoodsCity;

    private String takeGoodsCounty;

    private Date sendGoodsTime;
    private String sendGoodsTimeToString;

    private Double orderFreight;

    private Date orderCompletionTime;
    private String orderCompletionTimeToString;


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
        this.userUuid = userUuid;
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
        this.takeGoodsName = takeGoodsName;
    }

    public String getTakeGoodsPhone() {
        return takeGoodsPhone;
    }

    public void setTakeGoodsPhone(String takeGoodsPhone) {
        this.takeGoodsPhone = takeGoodsPhone;
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
        this.sendWay = sendWay;
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
        this.buyMessage = buyMessage;
    }

    public String getTakeGoodsProvince() {
        return takeGoodsProvince;
    }

    public void setTakeGoodsProvince(String takeGoodsProvince) {
        this.takeGoodsProvince = takeGoodsProvince;
    }

    public String getTakeGoodsCity() {
        return takeGoodsCity;
    }

    public void setTakeGoodsCity(String takeGoodsCity) {
        this.takeGoodsCity = takeGoodsCity;
    }

    public String getTakeGoodsCounty() {
        return takeGoodsCounty;
    }

    public void setTakeGoodsCounty(String takeGoodsCounty) {
        this.takeGoodsCounty = takeGoodsCounty;
    }


    public Double getOrderFreight() {
        return orderFreight;
    }

    public void setOrderFreight(Double orderFreight) {
        this.orderFreight = orderFreight;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public void setOrderCreateTimeToString(String orderCreateTimeToString) {
        this.orderCreateTimeToString = orderCreateTimeToString;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public void setOrderPayTimeToString(String orderPayTimeToString) {
        this.orderPayTimeToString = orderPayTimeToString;
    }

    public void setSendGoodsTime(Date sendGoodsTime) {
        this.sendGoodsTime = sendGoodsTime;
    }

    public void setSendGoodsTimeToString(String sendGoodsTimeToString) {
        this.sendGoodsTimeToString = sendGoodsTimeToString;
    }

    public void setOrderCompletionTime(Date orderCompletionTime) {
        this.orderCompletionTime = orderCompletionTime;
    }

    public void setOrderCompletionTimeToString(String orderCompletionTimeToString) {
        this.orderCompletionTimeToString = orderCompletionTimeToString;
    }

    public Date getOrderCreateTime() {

        return orderCreateTime;
    }

    public String getOrderCreateTimeToString() {
        return dateFormatTool.dateToString(orderCreateTime, "FULL_TIME");
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public String getOrderPayTimeToString() {
        return dateFormatTool.dateToString(orderPayTime, "FULL_TIME");
    }

    public Date getSendGoodsTime() {
        return sendGoodsTime;
    }

    public String getSendGoodsTimeToString() {
        return dateFormatTool.dateToString(sendGoodsTime, "FULL_TIME");
    }

    public Date getOrderCompletionTime() {
        return orderCompletionTime;
    }

    public String getOrderCompletionTimeToString() {
        return dateFormatTool.dateToString(orderCompletionTime, "FULL_TIME");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userUuid='" + userUuid + '\'' +
                ", shopId=" + shopId +
                ", takeGoodsName='" + takeGoodsName + '\'' +
                ", takeGoodsPhone='" + takeGoodsPhone + '\'' +
                ", takeGoodsPost=" + takeGoodsPost +
                ", orderSumPrice=" + orderSumPrice +
                ", useScore=" + useScore +
                ", sendScore=" + sendScore +
                ", payStatus=" + payStatus +
                ", sendStatus=" + sendStatus +
                ", discussStatus=" + discussStatus +
                ", protectStatus=" + protectStatus +
                ", payType=" + payType +
                ", orderCreateTime=" + orderCreateTime +
                ", orderCreateTimeToString='" + dateFormatTool.dateToString(orderCreateTime, "FULL_TIME") + '\'' +
                +'\'' +
                ", orderPayTime=" + orderPayTime +
                ", orderPayTimeToString='" + dateFormatTool.dateToString(orderPayTime, "FULL_TIME") + '\'' +
                ", orderPaid=" + orderPaid +
                ", orderRefund=" + orderRefund +
                ", sendWay='" + sendWay + '\'' +
                ", addressId=" + addressId +
                ", buyMessage='" + buyMessage + '\'' +
                ", takeGoodsProvince='" + takeGoodsProvince + '\'' +
                ", takeGoodsCity='" + takeGoodsCity + '\'' +
                ", takeGoodsCounty='" + takeGoodsCounty + '\'' +
                ", sendGoodsTime=" + sendGoodsTime +
                ", sendGoodsTimeToString='" + dateFormatTool.dateToString(sendGoodsTime, "FULL_TIME") + '\'' +
                ", orderFreight=" + orderFreight +
                ", orderCompletionTime=" + orderCompletionTime +
                ", orderCompletionTimeToString='" + dateFormatTool.dateToString(orderCompletionTime, "FULL_TIME") + '\'' +
                '}';
    }
}