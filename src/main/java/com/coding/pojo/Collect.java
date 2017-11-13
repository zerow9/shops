package com.coding.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Collect {
    private Integer collectId;

    private String userUuid;

    private Integer itemId;

    private String itemName;

    private String itemImages;

    private Date collectTime;

    private Integer collectItemVender;

    private String collectRemark;


    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages == null ? null : itemImages.trim();
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getCollectItemVender() {
        return collectItemVender;
    }

    public void setCollectItemVender(Integer collectItemVender) {
        this.collectItemVender = collectItemVender;
    }

    public String getCollectRemark() {
        return collectRemark;
    }

    public void setCollectRemark(String collectRemark) {
        this.collectRemark = collectRemark == null ? null : collectRemark.trim();
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectId=" + collectId +
                ", userUuid='" + userUuid + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemImages='" + itemImages + '\'' +
                ", collectTime=" + collectTime +
                ", collectItemVender=" + collectItemVender +
                ", collectRemark='" + collectRemark + '\'' +
                '}';
    }
}