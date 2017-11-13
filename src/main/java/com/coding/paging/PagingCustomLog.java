package com.coding.paging;

import com.coding.pojo.Log;

public class PagingCustomLog extends Paging {
    private Log log;

    private String formerLogLandTime;//一些功能需要登录时间范围内查询，这是左侧较小值

    private String latterLogLandTime;//一些功能需要登录时间范围内查询，这是右侧较大值

    private String formerSpaceTime;//一些功能需要登录间隔时间范围内查询，这是左侧较小值

    private String latterSpaceTime;//一些功能需要登录间隔时间范围内查询，这是右侧较大值

    public void setLog(Log log) {
        this.log = log;
    }

    public void setFormerLogLandTime(String formerLogLandTime) {
        this.formerLogLandTime = formerLogLandTime;
    }

    public void setLatterLogLandTime(String latterLogLandTime) {
        this.latterLogLandTime = latterLogLandTime;
    }

    public void setFormerSpaceTime(String formerSpaceTime) {
        this.formerSpaceTime = formerSpaceTime;
    }

    public void setLatterSpaceTime(String latterSpaceTime) {
        this.latterSpaceTime = latterSpaceTime;
    }

    public Log getLog() {
        return log;
    }

    public String getFormerLogLandTime() {
        return formerLogLandTime;
    }

    public String getLatterLogLandTime() {
        return latterLogLandTime;
    }

    public String getFormerSpaceTime() {
        return formerSpaceTime;
    }

    public String getLatterSpaceTime() {
        return latterSpaceTime;
    }

    @Override
    public String toString() {
        return "PagingCustomLog{" +
                "log=" + log +
                ", formerLogLandTime='" + formerLogLandTime + '\'' +
                ", latterLogLandTime='" + latterLogLandTime + '\'' +
                ", formerSpaceTime='" + formerSpaceTime + '\'' +
                ", latterSpaceTime='" + latterSpaceTime + '\'' +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
