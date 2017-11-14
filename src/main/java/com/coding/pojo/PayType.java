package com.coding.pojo;

import org.springframework.stereotype.Component;

@Component
public class PayType {
    private Integer payTypeId;

    private String payTypeName;


    public Integer getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName == null ? null : payTypeName.trim();
    }

    @Override
    public String toString() {
        return "PayType{" +
                "payTypeId=" + payTypeId +
                ", payTypeName='" + payTypeName + '\'' +
                '}';
    }
}