package com.coding.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class User {
    private String userUuid;

    private String userPhone;

    private String userNickname;

    private String userPassword;

    private String userEmail;

    private String userName;

    private Integer userAge;

    private String userSex;

    private Date userRegisterDateTime;

    private Integer userScore;

    private Integer userGroup;

    private Integer userLandNumber;

    private Date userCurrentTime;

    private String userLandIp;

    private Integer userAddress;

    private String dateToString;
    private String userHealthy;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserRegisterDateTime() {
        return userRegisterDateTime;
    }

    public void setUserRegisterDateTime(Date userRegisterDateTime) {
        this.userRegisterDateTime = userRegisterDateTime;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    public Integer getUserLandNumber() {
        return userLandNumber;
    }

    public void setUserLandNumber(Integer userLandNumber) {
        this.userLandNumber = userLandNumber;
    }

    public Date getUserCurrentTime() {
        return userCurrentTime;
    }

    public void setUserCurrentTime(Date userCurrentTime) {
        this.userCurrentTime = userCurrentTime;
    }

    public String getUserLandIp() {
        return userLandIp;
    }

    public void setUserLandIp(String userLandIp) {
        this.userLandIp = userLandIp == null ? null : userLandIp.trim();
    }

    public Integer getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Integer userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserHealthy() {
        return userHealthy;
    }

    public void setUserHealthy(String userHealthy) {
        this.userHealthy = userHealthy == null ? null : userHealthy.trim();
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    public String getDateToString() {
        return dateToString;
    }

    @Override
    public String toString() {
        return "User{" +
                "userUuid='" + userUuid + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", userRegisterDateTime=" + userRegisterDateTime +
                ", userScore=" + userScore +
                ", userGroup=" + userGroup +
                ", userLandNumber=" + userLandNumber +
                ", userCurrentTime=" + userCurrentTime +
                ", userLandIp='" + userLandIp + '\'' +
                ", userAddress=" + userAddress +
                ", userHealthy='" + userHealthy + '\'' +
                ", dateToString='" + dateToString + '\'' +
                '}';
    }
}