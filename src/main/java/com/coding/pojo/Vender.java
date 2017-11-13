package com.coding.pojo;


public class Vender {
    private Integer venderId;

    private String venderName;

    private String venderAddress;

    private String venderPhone;

    private Integer icId;

    private String businessRange;

    private String venderEmail;

    private Integer venderPost;


    public Integer getVenderId() {
        return venderId;
    }

    public void setVenderId(Integer venderId) {
        this.venderId = venderId;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName == null ? null : venderName.trim();
    }

    public String getVenderAddress() {
        return venderAddress;
    }

    public void setVenderAddress(String venderAddress) {
        this.venderAddress = venderAddress == null ? null : venderAddress.trim();
    }

    public String getVenderPhone() {
        return venderPhone;
    }

    public void setVenderPhone(String venderPhone) {
        this.venderPhone = venderPhone == null ? null : venderPhone.trim();
    }

    public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public String getBusinessRange() {
        return businessRange;
    }

    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange == null ? null : businessRange.trim();
    }

    public String getVenderEmail() {
        return venderEmail;
    }

    public void setVenderEmail(String venderEmail) {
        this.venderEmail = venderEmail == null ? null : venderEmail.trim();
    }

    public Integer getVenderPost() {
        return venderPost;
    }

    public void setVenderPost(Integer venderPost) {
        this.venderPost = venderPost;
    }

    @Override
    public String toString() {
        return "Vender{" +
                "venderId=" + venderId +
                ", venderName='" + venderName + '\'' +
                ", venderAddress='" + venderAddress + '\'' +
                ", venderPhone='" + venderPhone + '\'' +
                ", icId=" + icId +
                ", businessRange='" + businessRange + '\'' +
                ", venderEmail='" + venderEmail + '\'' +
                ", venderPost=" + venderPost +
                '}';
    }
}