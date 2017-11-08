package com.coding.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Notice {
    private Integer noticeId;

    private String noiceTime;

    private Integer isUse;

    private String noticeContent;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoiceTime() {
        return noiceTime;
    }

    public void setNoiceTime(String noiceTime) {
        this.noiceTime = noiceTime;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }


    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent ;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noiceTime=" + noiceTime +
                ", isUse=" + isUse +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}