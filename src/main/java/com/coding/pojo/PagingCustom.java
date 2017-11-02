package com.coding.pojo;

public class PagingCustom {
    // x是当前页数，y是每页显示的个数
    private Integer indexNumber;//分页功能中 当前所在页的开始数（不是单纯的页数，是计算后的数值 (x-1)*y+1）

    private Integer pageNumber;//分页功能中 每页显示的个数（不是单纯的页数，是计算后的数值 x*y）

    private String keyWord;//模糊查询中用到的关键字

    private String sortByColumn;//一些功能里面需要根据不同的字段去排序

    private String sortRule;//排序规则 ASC:升序  DESC：降序

    private Integer formerAge;//一些功能需要范围内查询，这是左侧较小值

    private Integer latterAge;//一些功能需要范围内查询，这是右侧较大值


    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getSortByColumn() {
        return sortByColumn;
    }

    public void setSortByColumn(String sortByColumn) {
        this.sortByColumn = sortByColumn;
    }

    public String getSortRule() {
        return sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
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
}
