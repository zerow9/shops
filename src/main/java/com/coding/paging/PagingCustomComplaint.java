package com.coding.paging;

import com.coding.pojo.Complaint;

public class PagingCustomComplaint extends Paging {
    private Complaint complaint;

    //采用字符串格式是因为可以较简单的通过 mybatis 传入数据库进行比较
    //格式要和数据库 dateTime 一样  yyyy-MM-dd HH:mm:ss
    private String formerComplaintDate;//一些功能需要时间范围内查询，这是左侧较小值

    //采用字符串格式是因为可以较简单的通过 mybatis 传入数据库进行比较
    //格式要和数据库 dateTime 一样  yyyy-MM-dd HH:mm:ss
    private String latterComplaintDate;//一些功能需要时间范围内查询，这是右侧较大值

    public String getFormerComplaintDate() {
        return formerComplaintDate;
    }

    public void setFormerComplaintDate(String formerComplaintDate) {
        this.formerComplaintDate = formerComplaintDate;
    }

    public String getLatterComplaintDate() {
        return latterComplaintDate;
    }

    public void setLatterComplaintDate(String latterComplaintDate) {
        this.latterComplaintDate = latterComplaintDate;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @Override
    public String toString() {
        return "PagingCustomComplaint{" +
                "complaint=" + complaint +
                ", formerComplaintDate='" + formerComplaintDate + '\'' +
                ", latterComplaintDate='" + latterComplaintDate + '\'' +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
