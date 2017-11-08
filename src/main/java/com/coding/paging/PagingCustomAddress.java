package com.coding.paging;

import com.coding.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;

public class PagingCustomAddress extends Paging {
    @Autowired
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
