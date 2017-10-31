package com.coding.controller;
import com.coding.mapper.*;

import com.coding.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class Test {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping("test")
    public void insertItem(){
       // List<Address> addressList = addressMapper.selectAddressByUserID("");
        //System.out.println(addressList);

//        Admin adminList = adminMapper.selectAdminByPrimaryKey(0);
//        System.out.println(adminList);
        Item item = new Item();
        item.setItemCollectNumber(1);
        item.setItemFormat("1");
        item.setItemImages("1");
        item.setItemIntroduce("1");
        item.setItemMarketPrice(22.5);
        item.setItemName("脚气膏");
        item.setItemPrice(11.1);
        item.setItemSaleNumber(11);
        item.setItemScoreType(1);
        item.setItemTypeId(2);
        item.setScorePrice(600);
        item.setRepertoryNumber(3);
        item.setPostPrice(33.3);
        item.setMakeDate(new Date());
        item.setKeyWord("1");
        item.setMakeVender(1);
        item.setItemTypeThree(2);
        item.setItemTypeTwo(3);
        item.setItemTypeOne(4);
        itemMapper.insertItem(item);
    }
    @RequestMapping("test1")
    public void updateItemByPrimaryKey(){
        Item item = new Item();
        item.setItemCollectNumber(1);
        item.setItemFormat("1");
        item.setItemImages("1");
        item.setItemIntroduce("1");
        item.setItemMarketPrice(22.5);
        item.setItemName("脱毛膏");
        item.setItemPrice(11.1);
        item.setItemSaleNumber(11);
        item.setItemScoreType(1);
        item.setItemTypeId(2);
        item.setScorePrice(600);
        item.setRepertoryNumber(3);
        item.setPostPrice(33.3);
        item.setMakeDate(new Date());
        item.setKeyWord("1");
        item.setMakeVender(1);
        item.setItemTypeThree(2);
        item.setItemTypeTwo(3);
        item.setItemTypeOne(4);
        item.setItemId(1);
        itemMapper.updateItemByPrimaryKey(item);
    }
}
