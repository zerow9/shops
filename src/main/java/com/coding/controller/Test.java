package com.coding.controller;
import com.coding.mapper.*;

import com.coding.pojo.Item;
import com.coding.pojo.ItemType;
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

    @Autowired
    private ItemTypeMapper itemTypeMapper;

    @RequestMapping("test")
    public void insertRepertory()throws Exception {
//        ItemType itemType = new ItemType();
//        itemType.setFatherTypeId(1);
//        itemType.setTypeIntroduce("1");
//        itemType.setTypeKeyWord("b");
//        itemType.setTypeLevel(2);
//        itemType.setTypeName("bb");
//        itemType.setTypeId(1);
//        itemTypeMapper.insertItemType(itemType);

      //itemTypeMapper.deleteItemTypeByPrimaryKey(2);
//        ItemType itemType = itemTypeMapper.selectItemTypeByPrimaryKey(null);
//        System.out.println(itemType);

//        itemTypeMapper.updateItemTypeByPrimaryKey(itemType);

        List<ItemType> itemTypeList = itemTypeMapper.selectItemTypeAll();
        System.out.println(itemTypeList);
    }

}
