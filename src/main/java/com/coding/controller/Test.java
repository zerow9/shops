package com.coding.controller;
import com.coding.mapper.*;

import com.coding.pojo.Item;
import com.coding.pojo.Repertory;
import com.coding.pojo.Vender;
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

    @Autowired
    private VenderMapper venderMapper;

    @RequestMapping("test")
    public void insertRepertory()throws Exception {
//        Vender vender = new Vender();
//        vender.setBusinessRange("a-b");
//        vender.setIcId(123213);
//        vender.setVenderAddress("北京a a a ");
//        vender.setVenderEmail("asdsa@asd.com");
//        vender.setVenderName("北京老布鞋");
//        vender.setVenderPhone("12312312");
//        vender.setVenderPost(12312);
//        vender.setVenderId(3);
////        venderMapper.insertVender(vender);
//
////        List<Vender> venders = venderMapper.selectVenderAll();
////        System.out.println(venders);
////        Vender vender1 = venderMapper.selectVenderByPrimaryKey(null);
////        System.out.println(vender1);
//
//          venderMapper.updateVenderByPrimaryKey(vender);

        venderMapper.deleteVenderByPrimaryKey(2);
    }

}
