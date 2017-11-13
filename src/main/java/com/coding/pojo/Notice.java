package com.coding.pojo;


import java.util.Date;
public class Notice {
    private Integer noticeId;

    private Date noiceTime;
    private String noiceTimeToString;

    private Integer isUse;

    private String noticeContent;


    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Date getNoiceTime() {
        return noiceTime;
    }

    public void setNoiceTimeToString(String noiceTimeToString) {
        this.noiceTimeToString = noiceTimeToString;
    }

    public String getNoiceTimeToString() {

        return noiceTimeToString;
    }

    public void setNoiceTime(Date noiceTime) {
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
                ", noiceTimeToString='" + noiceTimeToString + '\'' +
                ", isUse=" + isUse +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}