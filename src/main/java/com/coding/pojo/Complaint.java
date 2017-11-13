package com.coding.pojo;


import java.util.Date;

public class Complaint {
    private Integer complaintId;

    private String accuserId;

    private Integer accusedId;

    private String complaintTittle;

    private Date complaintDate;

    private Integer isDeal;

    private String complaintContent;

    private boolean status;

    private String dateToString;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    public String getDateToString() {
        return dateToString;
    }

    public boolean getStatus() {
        return status;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getAccuserId() {
        return accuserId;
    }

    public void setAccuserId(String accuserId) {
        this.accuserId = accuserId;
    }

    public Integer getAccusedId() {
        return accusedId;
    }

    public void setAccusedId(Integer accusedId) {
        this.accusedId = accusedId;
    }

    public String getComplaintTittle() {
        return complaintTittle;
    }

    public void setComplaintTittle(String complaintTittle) {
        this.complaintTittle = complaintTittle == null ? null : complaintTittle.trim();
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public Integer getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    public String getComplaintContent() {
        return complaintContent;
    }

    public void setComplaintContent(String complaintContent) {
        this.complaintContent = complaintContent == null ? null : complaintContent.trim();
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", accuserId='" + accuserId + '\'' +
                ", accusedId=" + accusedId +
                ", complaintTittle='" + complaintTittle + '\'' +
                ", complaintDate=" + complaintDate +
                ", isDeal=" + isDeal +
                ", complaintContent='" + complaintContent + '\'' +
                ", status=" + status +
                ", dateToString='" + dateToString + '\'' +
                '}';
    }
}