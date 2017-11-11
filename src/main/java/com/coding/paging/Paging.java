package com.coding.paging;

public class Paging {
    // x是当前页数，y是每页显示的个数
    protected Integer indexNumber;//分页功能中 当前所在页的开始数（不是单纯的页数，是计算后的数值 (x-1)*y+1）

    protected Integer pageNumber;//分页功能中 每页显示的个数（不是单纯的页数，是计算后的数值 x*y）

    protected String keyWord;//模糊查询中用到的关键字

    protected String sortByColumn;//一些功能里面需要根据不同的字段去排序

    protected String sortRule;//排序规则 ASC:升序  DESC：降序

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

    public void addIndex(int page, int limit) {
        this.setPageNumber(limit);
        this.setIndexNumber((page - 1) * limit);
    }


    @Override
    public String toString() {
        return "Paging{" +
                "indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
