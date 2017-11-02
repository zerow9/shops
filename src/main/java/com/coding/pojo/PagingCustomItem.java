package com.coding.pojo;

public class PagingCustomItem extends Paging {
    private Double formerPrice;//一些功能需要价格范围内查询，这是左侧较小值

    private Double latterPrice;//一些功能需要价格范围内查询，这是右侧较大值

    private Integer formerRepertoryNumber;//一些功能需要库存范围内查询，这是左侧较小值

    private Integer latterRepertoryNumber;//一些功能需要库存范围内查询，这是左侧较大值

    private Item item;//封装了商品信息，当需要利用商品的基本信息查询时调用

    public Double getFormerPrice() {
        return formerPrice;
    }

    public void setFormerPrice(Double formerPrice) {
        this.formerPrice = formerPrice;
    }

    public Double getLatterPrice() {
        return latterPrice;
    }

    public void setLatterPrice(Double latterPrice) {
        this.latterPrice = latterPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getFormerRepertoryNumber() {
        return formerRepertoryNumber;
    }

    public void setFormerRepertoryNumber(Integer formerRepertoryNumber) {
        this.formerRepertoryNumber = formerRepertoryNumber;
    }

    public Integer getLatterRepertoryNumber() {
        return latterRepertoryNumber;
    }

    public void setLatterRepertoryNumber(Integer latterRepertoryNumber) {
        this.latterRepertoryNumber = latterRepertoryNumber;
    }
}
