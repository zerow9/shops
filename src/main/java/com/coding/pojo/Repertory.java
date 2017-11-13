package com.coding.pojo;

import java.util.Date;

public class Repertory {
    private Integer repertoryId;

    private Integer itemId;

    private String itemName;

    private Double itemMarketPrice;

    private Double itemOriginalPrice;

    private Integer shopId;

    private Integer repertoryNumber;

    private Date repertoryPuttime;
    private String puttimeToString;

    private Date updateTime;
    private String updateToString;


    private Integer venderId;


    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setPuttimeToString(String puttimeToString) {
        this.puttimeToString = puttimeToString;
    }

    public void setUpdateToString(String updateToString) {
        this.updateToString = updateToString;
    }

    public String getPuttimeToString() {

        return puttimeToString;
    }

    public String getUpdateToString() {
        return updateToString;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
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

    public Double getItemMarketPrice() {
        return itemMarketPrice;
    }

    public void setItemMarketPrice(Double itemMarketPrice) {
        this.itemMarketPrice = itemMarketPrice;
    }

    public Double getItemOriginalPrice() {
        return itemOriginalPrice;
    }

    public void setItemOriginalPrice(Double itemOriginalPrice) {
        this.itemOriginalPrice = itemOriginalPrice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getRepertoryNumber() {
        return repertoryNumber;
    }

    public void setRepertoryNumber(Integer repertoryNumber) {
        this.repertoryNumber = repertoryNumber;
    }

    public Date getRepertoryPuttime() {
        return repertoryPuttime;
    }

    public void setRepertoryPuttime(Date repertoryPuttime) {
        this.repertoryPuttime = repertoryPuttime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVenderId() {
        return venderId;
    }

    public void setVenderId(Integer venderId) {
        this.venderId = venderId;
    }

    public String toString() {
        return "Repertory{" +
                "repertoryId=" + repertoryId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemMarketPrice=" + itemMarketPrice +
                ", itemOriginalPrice=" + itemOriginalPrice +
                ", shopId=" + shopId +
                ", repertoryNumber=" + repertoryNumber +
                ", repertoryPuttime=" + repertoryPuttime +
                ", puttimeToString='" + puttimeToString + '\'' +
                ", updateTime=" + updateTime +
                ", updateToString='" + updateToString + '\'' +
                ", venderId=" + venderId +
                '}';
    }
}