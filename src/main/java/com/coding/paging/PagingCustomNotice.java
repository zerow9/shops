package com.coding.paging;

import com.coding.pojo.Notice;
public class PagingCustomNotice extends Paging {
    private Notice notice;

    private String formerNoiceTime;//一些功能需要公告发布时间范围内查询，这是左侧较小值

    private String latterNoiceTime;//一些功能需要公告发布时间范围内查询，这是右侧较大值

    public Notice getNotice() {
        return notice;
    }

    public String getFormerNoiceTime() {
        return formerNoiceTime;
    }

    public String getLatterNoiceTime() {
        return latterNoiceTime;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public void setFormerNoiceTime(String formerNoiceTime) {
        this.formerNoiceTime = formerNoiceTime;
    }

    public void setLatterNoiceTime(String latterNoiceTime) {
        this.latterNoiceTime = latterNoiceTime;
    }

    @Override
    public String toString() {
        return "PagingCustomNotice{" +
                "notice=" + notice +
                ", formerNoiceTime=" + formerNoiceTime +
                ", latterNoiceTime=" + latterNoiceTime +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
