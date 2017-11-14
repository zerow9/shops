package com.coding.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Discuss {
    private Integer discussId;

    private Integer shopId;

    private Integer itemId;

    private String discussDetail;

    private String userUuid;

    private String replyContent;

    private Date discussTime;


    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDiscussDetail() {
        return discussDetail;
    }

    public void setDiscussDetail(String discussDetail) {
        this.discussDetail = discussDetail == null ? null : discussDetail.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(Date discussTime) {
        this.discussTime = discussTime;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "discussId=" + discussId +
                ", shopId=" + shopId +
                ", itemId=" + itemId +
                ", discussDetail='" + discussDetail + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", discussTime=" + discussTime +
                '}';
    }
}