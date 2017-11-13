package com.coding.paging;

import com.coding.pojo.Orders;

public class PagingCustomOrder extends Paging {
    private Orders order;//订单基本信息

    private String formerOrderCreateTime;//一些功能需要订单创建时间范围内查询，这是左侧较小值

    private String latterOrderCreateTime;//一些功能需要订单创建时间范围内查询，这是右侧较大值

    private String formerOrderPayTime;//一些功能需要订单支付时间范围内查询，这是左侧较小值

    private String latterOrderPayTime;//一些功能需要订单支付时间范围内查询，这是右侧较大值

    private String formerSendGoodsTime;//一些功能需要订单发货时间范围内查询，这是左侧较小值

    private String latterSendGoodsTime;//一些功能需要订单发货时间范围内查询，这是右侧较大值

    private String formerOrderCompletionTime;//一些功能需要订单完成时间范围内查询，这是左侧较小值

    private String latterOrderCompletionTime;//一些功能需要订单完成时间范围内查询，这是右侧较大值


    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getFormerOrderCreateTime() {
        return formerOrderCreateTime;
    }

    public void setFormerOrderCreateTime(String formerOrderCreateTime) {
        this.formerOrderCreateTime = formerOrderCreateTime;
    }

    public String getLatterOrderCreateTime() {
        return latterOrderCreateTime;
    }

    public void setLatterOrderCreateTime(String latterOrderCreateTime) {
        this.latterOrderCreateTime = latterOrderCreateTime;
    }

    public String getFormerOrderPayTime() {
        return formerOrderPayTime;
    }

    public void setFormerOrderPayTime(String formerOrderPayTime) {
        this.formerOrderPayTime = formerOrderPayTime;
    }

    public String getLatterOrderPayTime() {
        return latterOrderPayTime;
    }

    public void setLatterOrderPayTime(String latterOrderPayTime) {
        this.latterOrderPayTime = latterOrderPayTime;
    }

    public String getFormerSendGoodsTime() {
        return formerSendGoodsTime;
    }

    public void setFormerSendGoodsTime(String formerSendGoodsTime) {
        this.formerSendGoodsTime = formerSendGoodsTime;
    }

    public String getLatterSendGoodsTime() {
        return latterSendGoodsTime;
    }

    public void setLatterSendGoodsTime(String latterSendGoodsTime) {
        this.latterSendGoodsTime = latterSendGoodsTime;
    }

    public String getFormerOrderCompletionTime() {
        return formerOrderCompletionTime;
    }

    public void setFormerOrderCompletionTime(String formerOrderCompletionTime) {
        this.formerOrderCompletionTime = formerOrderCompletionTime;
    }

    public String getLatterOrderCompletionTime() {
        return latterOrderCompletionTime;
    }

    public void setLatterOrderCompletionTime(String latterOrderCompletionTime) {
        this.latterOrderCompletionTime = latterOrderCompletionTime;
    }

    @Override
    public String toString() {
        return "PagingCustomOrder{" +
                "order=" + order +
                ", formerOrderCreateTime='" + formerOrderCreateTime + '\'' +
                ", latterOrderCreateTime='" + latterOrderCreateTime + '\'' +
                ", formerOrderPayTime='" + formerOrderPayTime + '\'' +
                ", latterOrderPayTime='" + latterOrderPayTime + '\'' +
                ", formerSendGoodsTime='" + formerSendGoodsTime + '\'' +
                ", latterSendGoodsTime='" + latterSendGoodsTime + '\'' +
                ", formerOrderCompletionTime='" + formerOrderCompletionTime + '\'' +
                ", latterOrderCompletionTime='" + latterOrderCompletionTime + '\'' +
                ", indexNumber=" + indexNumber +
                ", pageNumber=" + pageNumber +
                ", keyWord='" + keyWord + '\'' +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortRule='" + sortRule + '\'' +
                '}';
    }
}
