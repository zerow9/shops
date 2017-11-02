package com.coding.pojo;

public class PagingCustomUser extends Paging{
    private Integer formerAge;//一些功能需要年龄范围内查询，这是左侧较小值

    private Integer latterAge;//一些功能需要年龄范围内查询，这是右侧较大值

    private User user;

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
}
