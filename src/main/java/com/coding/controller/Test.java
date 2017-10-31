package com.coding.controller;
import com.coding.mapper.*;

import com.coding.pojo.Item;
import com.coding.pojo.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class Test {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private RepertoryMapper repertoryMapper;

    @RequestMapping("test")
    public void insertRepertory()throws Exception {
        Repertory repertory = new Repertory();
        repertory.setItemId(1);
        repertory.setItemMarketPrice(22.5);
        repertory.setItemOriginalPrice(22.0);
        repertory.setRepertoryNumber(3);
        repertory.setRepertoryPuttime(new Date());
        repertory.setShopId(33);
        repertory.setUpdateTime(new Date());
        repertory.setVenderId(1);
        repertory.setRepertoryId(9);
        repertoryMapper.updateRepertoryByPrimaryKey(repertory);
//        repertoryMapper.insertRepertory(repertory);

//        repertoryMapper.deleteRepertoryByPrimaryKey(1);

//        Repertory repertory = repertoryMapper.selectRepertoryByPrimaryKey(0);
//        System.out.println(repertory);
//          List<Repertory> repertoryList = repertoryMapper.selectRepertoryAll();
//          System.out.println(repertoryList);



    }

}
