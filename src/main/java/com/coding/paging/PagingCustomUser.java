package com.coding.paging;

import com.coding.pojo.User;

public class PagingCustomUser extends Paging{

    private Integer formerAge;//一些功能需要年龄范围内查询，这是左侧较小值

    private Integer latterAge;//一些功能需要年龄范围内查询，这是右侧较大值

    private Integer formerScore;//一些功能需要积分范围内查询，这是左侧较小值

    private Integer latterScore;//一些功能需要积分范围内查询，这是右侧较大值

    private String formerUserCreateTime;//一些功能需要用户注册时间范围内查询，这是左侧较小值

    private String latterUserCreateTime;//一些功能需要用户注册时间范围内查询，这是右侧较大值


    private User user; //对于User对象，只用到了其中的userSex、userGroup 两个属性，其他属性不做利用
    //对于User对象，只用到了其中的userSex、
    // userGroup 两个属性，其他属性不做利用


    public String getFormerUserCreateTime() {
        return formerUserCreateTime;
    }

    public void setFormerUserCreateTime(String formerUserCreateTime) {
        this.formerUserCreateTime = formerUserCreateTime;
    }

    public String getLatterUserCreateTime() {
        return latterUserCreateTime;
    }

    public void setLatterUserCreateTime(String latterUserCreateTime) {
        this.latterUserCreateTime = latterUserCreateTime;
    }

    public Integer getFormerAge() {
        return formerAge;
    }

    public void setFormerAge(Integer formerAge) {
        this.formerAge = formerAge;
    }

    public Integer getLatterAge() {
        return latterAge;
    }

    public void setLatterAge(Integer latterAge) {
        this.latterAge = latterAge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFormerScore() {
        return formerScore;
    }

    public void setFormerScore(Integer formerScore) {
        this.formerScore = formerScore;
    }

    public Integer getLatterScore() {
        return latterScore;
    }

    public void setLatterScore(Integer latterScore) {
        this.latterScore = latterScore;
    }
    

    @Override
    public String toString() {
        return "PagingCustomUser{" +
                "formerAge=" + formerAge +
                ", latterAge=" + latterAge +
                ", formerScore=" + formerScore +
                ", latterScore=" + latterScore +
                ", user=" + user +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
