package com.coding.controller;

import com.coding.mapper.AddressMapper;
import com.coding.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class Test {
    @Autowired
    private AddressMapper addressMapper;

    @RequestMapping("test")
    public void selectAddressAll(){
        System.out.println("Controller~~~");
        List<Address> addressList = addressMapper.selectAddressAll();
        System.out.println(addressList);
    }

}
