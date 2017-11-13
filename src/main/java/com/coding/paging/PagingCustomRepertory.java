package com.coding.paging;

import com.coding.pojo.Repertory;

public class PagingCustomRepertory extends Paging {

    private Repertory repertory;

    private double formerItemMarketPrice;//一些功能需要库存市场价格范围内查询，这是左侧较小值

    private double latterItemMarketPrice;//一些功能需要库存市场价格范围内查询，这是右侧较大值

    private double formerItemOriginalPrice;//一些功能需要库存原价价格范围内查询，这是左侧较小值

    private double latterItemOriginalPrice;//一些功能需要库存原价价格范围内查询，这是右侧较大值

    private int formerRepertoryNumber;//一些功能需要库存数量范围内查询，这是左侧较小值

    private int latterRepertoryNumber;//一些功能需要库存数量范围内查询，这是右侧较大值

    public void setFormerItemMarketPrice(double formerItemMarketPrice) {
        this.formerItemMarketPrice = formerItemMarketPrice;
    }

    public void setLatterItemMarketPrice(double latterItemMarketPrice) {
        this.latterItemMarketPrice = latterItemMarketPrice;
    }

    public void setFormerItemOriginalPrice(double formerItemOriginalPrice) {
        this.formerItemOriginalPrice = formerItemOriginalPrice;
    }

    public void setLatterItemOriginalPrice(double latterItemOriginalPrice) {
        this.latterItemOriginalPrice = latterItemOriginalPrice;
    }

    public void setFormerRepertoryNumber(int formerRepertoryNumber) {
        this.formerRepertoryNumber = formerRepertoryNumber;
    }

    public void setLatterRepertoryNumber(int latterRepertoryNumber) {
        this.latterRepertoryNumber = latterRepertoryNumber;
    }

    public double getFormerItemMarketPrice() {

        return formerItemMarketPrice;
    }

    public double getLatterItemMarketPrice() {
        return latterItemMarketPrice;
    }

    public double getFormerItemOriginalPrice() {
        return formerItemOriginalPrice;
    }

    public double getLatterItemOriginalPrice() {
        return latterItemOriginalPrice;
    }

    public int getFormerRepertoryNumber() {
        return formerRepertoryNumber;
    }

    public int getLatterRepertoryNumber() {
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
