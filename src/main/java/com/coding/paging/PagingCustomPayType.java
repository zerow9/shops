package com.coding.paging;

import com.coding.pojo.PayType;
import org.springframework.stereotype.Component;

@Component
public class PagingCustomPayType extends Paging{
    private PayType payType;

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }
}
