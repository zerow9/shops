package com.coding.pojo;

public class PagingCustomUser extends Paging{
//    protected Integer indexNumber;//分页功能中 当前所在页的开始数（不是单纯的页数，是计算后的数值 (x-1)*y+1）
//
//    protected Integer pageNumber;//分页功能中 每页显示的个数（不是单纯的页数，是计算后的数值 x*y）
//
//    protected String keyWord;//模糊查询中用到的关键字
//
//    protected String sortByColumn;//一些功能里面需要根据不同的字段去排序
//
//    protected String sortRule;//排序规则 ASC:升序  DESC：降序

    private Integer formerAge;//一些功能需要年龄范围内查询，这是左侧较小值

    private Integer latterAge;//一些功能需要年龄范围内查询，这是右侧较大值

    private User user; //对于User对象，只用到了其中的userSex、userGroup 两个属性，其他属性不做利用

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
