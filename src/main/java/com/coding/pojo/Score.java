package com.coding.pojo;


import java.util.Date;

public class Score {
    private Integer scoreId;

    private String userUuid;

    private Integer coreDetail;

    private Date scoreCreateTime;
    private String scoreCreateTimeToString;

    private Integer scoreCurrent;

    private Integer scoreTatol;

    public String getScoreCreateTimeToString() {
        return scoreCreateTimeToString;
    }

    public void setScoreCreateTimeToString(String scoreCreateTimeToString) {
        this.scoreCreateTimeToString = scoreCreateTimeToString;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public Integer getCoreDetail() {
        return coreDetail;
    }

    public void setCoreDetail(Integer coreDetail) {
        this.coreDetail = coreDetail;
    }

    public Date getScoreCreateTime() {
        return scoreCreateTime;
    }

    public void setScoreCreateTime(Date scoreCreateTime) {
        this.scoreCreateTime = scoreCreateTime;
    }

    public Integer getScoreCurrent() {
        return scoreCurrent;
    }

    public void setScoreCurrent(Integer scoreCurrent) {
        this.scoreCurrent = scoreCurrent;
    }

    public Integer getScoreTatol() {
        return scoreTatol;
    }

    public void setScoreTatol(Integer scoreTatol) {
        this.scoreTatol = scoreTatol;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", userUuid='" + userUuid + '\'' +
                ", coreDetail=" + coreDetail +
                ", scoreCreateTime=" + scoreCreateTime +
                ", scoreCreateTimeToString='" + scoreCreateTimeToString + '\'' +
                ", scoreCurrent=" + scoreCurrent +
                ", scoreTatol=" + scoreTatol +
                '}';
    }
}