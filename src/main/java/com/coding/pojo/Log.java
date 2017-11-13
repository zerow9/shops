package com.coding.pojo;


import java.util.Date;

public class Log {
    private Integer logId;

    private String userUuid;

    private String logHistoryIp;

    private Date logLandTime;
    private String dateToString;  //logLandTime 时间存字符串类型

    private Date logSpace;
    private String logSpaceToString;  //logSpace 时间存字符串类型

    private String logWeighting;

    private String itemStatus;

    private String itemTypeStatus;

    private String logKeyWord;



    public String getDateToString() {
        return dateToString;
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid ;
    }

    public String getLogHistoryIp() {
        return logHistoryIp;
    }

    public void setLogHistoryIp(String logHistoryIp) {
        this.logHistoryIp = logHistoryIp ;
    }

    public Date getLogLandTime() {
        return logLandTime;
    }

    public void setLogLandTime(Date logLandTime) {
        this.logLandTime = logLandTime;
    }

    public Date getLogSpace() {
        return logSpace;
    }

    public void setLogSpaceToString(String logSpaceToString) {
        this.logSpaceToString = logSpaceToString;
    }

    public String getLogSpaceToString() {

        return logSpaceToString;
    }

    public void setLogSpace(Date logSpace) {
        this.logSpace = logSpace;
    }

    public String getLogWeighting() {
        return logWeighting;
    }

    public void setLogWeighting(String logWeighting) {
        this.logWeighting = logWeighting ;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus ;
    }

    public String getItemTypeStatus() {
        return itemTypeStatus;
    }

    public void setItemTypeStatus(String itemTypeStatus) {
        this.itemTypeStatus = itemTypeStatus ;
    }

    public String getLogKeyWord() {
        return logKeyWord;
    }

    public void setLogKeyWord(String logKeyWord) {
        this.logKeyWord = logKeyWord ;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", userUuid='" + userUuid + '\'' +
                ", logHistoryIp='" + logHistoryIp + '\'' +
                ", logLandTime=" + logLandTime +
                ", dateToString='" + dateToString + '\'' +
                ", logSpace=" + logSpace +
                ", logSpaceToString='" + logSpaceToString + '\'' +
                ", logWeighting='" + logWeighting + '\'' +
                ", itemStatus='" + itemStatus + '\'' +
                ", itemTypeStatus='" + itemTypeStatus + '\'' +
                ", logKeyWord='" + logKeyWord + '\'' +
                '}';
    }
}