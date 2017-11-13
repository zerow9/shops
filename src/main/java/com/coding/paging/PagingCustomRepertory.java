package com.coding.paging;

import com.coding.pojo.Repertory;

public class PagingCustomRepertory extends Paging {

    private Repertory repertory;

    private Integer formerItemMarketPrice;//一些功能需要库存市场价格范围内查询，这是左侧较小值

    private Integer latterItemMarketPrice;//一些功能需要库存市场价格范围内查询，这是右侧较大值

    private Integer formerItemOriginalPrice;//一些功能需要库存原价价格范围内查询，这是左侧较小值

    private Integer latterItemOriginalPrice;//一些功能需要库存原价价格范围内查询，这是右侧较大值

    private Integer formerRepertoryNumber;//一些功能需要库存数量范围内查询，这是左侧较小值

    private Integer latterRepertoryNumber;//一些功能需要库存数量范围内查询，这是右侧较大值


    public void setFormerItemMarketPrice(Integer formerItemMarketPrice) {
        this.formerItemMarketPrice = formerItemMarketPrice;
    }

    public void setLatterItemMarketPrice(Integer latterItemMarketPrice) {
        this.latterItemMarketPrice = latterItemMarketPrice;
    }

    public void setFormerItemOriginalPrice(Integer formerItemOriginalPrice) {
        this.formerItemOriginalPrice = formerItemOriginalPrice;
    }

    public void setLatterItemOriginalPrice(Integer latterItemOriginalPrice) {
        this.latterItemOriginalPrice = latterItemOriginalPrice;
    }

    public void setFormerRepertoryNumber(Integer formerRepertoryNumber) {
        this.formerRepertoryNumber = formerRepertoryNumber;
    }

    public void setLatterRepertoryNumber(Integer latterRepertoryNumber) {
        this.latterRepertoryNumber = latterRepertoryNumber;
    }

    public Integer getFormerItemMarketPrice() {

        return formerItemMarketPrice;
    }

    public Integer getLatterItemMarketPrice() {
        return latterItemMarketPrice;
    }

    public Integer getFormerItemOriginalPrice() {
        return formerItemOriginalPrice;
    }

    public Integer getLatterItemOriginalPrice() {
        return latterItemOriginalPrice;
    }

    public Integer getFormerRepertoryNumber() {
        return formerRepertoryNumber;
    }

    public Integer getLatterRepertoryNumber() {
        return latterRepertoryNumber;
    }

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public String toString() {
        return "PagingCustomRepertory{" +
                "repertory=" + repertory +
                ", formerItemMarketPrice=" + formerItemMarketPrice +
                ", latterItemMarketPrice=" + latterItemMarketPrice +
                ", formerItemOriginalPrice=" + formerItemOriginalPrice +
                ", latterItemOriginalPrice=" + latterItemOriginalPrice +
                ", formerRepertoryNumber=" + formerRepertoryNumber +
                ", latterRepertoryNumber=" + latterRepertoryNumber +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
