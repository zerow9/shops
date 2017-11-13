package com.coding.pojo;


public class Address {


    private Integer addressId;

    private String userUuid;

    private String addresseePhone;

    private String address;

    private Integer isDefaultAddress;

    private String takeGoodsProvince;

    private String takeGoodsCity;

    private String takeGoodsCounty;

    private String takeGoodsName;

    private Double addressX;

    private Double addressY;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone == null ? null : addresseePhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsDefaultAddress() {
        return isDefaultAddress;
    }

    public void setIsDefaultAddress(Integer isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }

    public String getTakeGoodsProvince() {
        return takeGoodsProvince;
    }

    public void setTakeGoodsProvince(String takeGoodsProvince) {
        this.takeGoodsProvince = takeGoodsProvince == null ? null : takeGoodsProvince.trim();
    }

    public String getTakeGoodsCity() {
        return takeGoodsCity;
    }

    public void setTakeGoodsCity(String takeGoodsCity) {
        this.takeGoodsCity = takeGoodsCity == null ? null : takeGoodsCity.trim();
    }

    public String getTakeGoodsCounty() {
        return takeGoodsCounty;
    }

    public void setTakeGoodsCounty(String takeGoodsCounty) {
        this.takeGoodsCounty = takeGoodsCounty == null ? null : takeGoodsCounty.trim();
    }

    public String getTakeGoodsName() {
        return takeGoodsName;
    }

    public void setTakeGoodsName(String takeGoodsName) {
        this.takeGoodsName = takeGoodsName == null ? null : takeGoodsName.trim();
    }

    public Double getAddressX() {
        return addressX;
    }

    public void setAddressX(Double addressX) {
        this.addressX = addressX;
    }

    public Double getAddressY() {
        return addressY;
    }

    public void setAddressY(Double addressY) {
        this.addressY = addressY;
    }

    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userUuid='" + userUuid + '\'' +
                ", addresseePhone='" + addresseePhone + '\'' +
                ", address='" + address + '\'' +
                ", isDefaultAddress=" + isDefaultAddress +
                ", takeGoodsProvince='" + takeGoodsProvince + '\'' +
                ", takeGoodsCity='" + takeGoodsCity + '\'' +
                ", takeGoodsCounty='" + takeGoodsCounty + '\'' +
                ", takeGoodsName='" + takeGoodsName + '\'' +
                ", addressX=" + addressX +
                ", addressY=" + addressY +
                '}';
    }
}