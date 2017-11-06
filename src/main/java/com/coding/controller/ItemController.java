package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.pojo.Item;
import com.coding.pojo.PagingCustomItem;
import com.coding.pojo.templet.JsonFormat;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    private Integer counts=null;

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;

    /**
     * 查询商品列表信息
     * @param page 第几页
     * @param limit 每页显示几个
     * @return 商品劣列表数据
     */
    @RequestMapping("getItemsAll")
    @ResponseBody
    public String getItemsAll(Integer page, Integer limit) throws Exception {
        PagingCustomItem pagingCustomItem = new PagingCustomItem();
        pagingCustomItem.setIndexNumber((page-1)*limit);
        pagingCustomItem.setPageNumber(limit);
        if ((page == 1 && counts == null) || counts == null)
            counts = adminService.selectItemCount();
        List<Item> items = adminService.selectItem(pagingCustomItem);
        for (Item item : items)
            item.setDateToString(DateToString.date(item.getMakeDate()));
        JsonFormat<Item> json = new JsonFormat<>(items, counts, null, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
    }

    /**
     * 商品列表页的跳转
     * @return 商品列表页
     */
    @RequestMapping("forwardItemList")
    public String forwardItemList() throws Exception {
        return "items/itemList";
    }

    /**
     * 获取商品详情页数据
     * @param itemId 商品ID
     * @return 详情页数据
     */
    @RequestMapping("detailItemsIdByKey")
    public String detailItemsIdByKey(Integer itemId, Model model) throws Exception {
        Item item = adminService.selectItemByPrimaryKey(itemId);
        System.out.println(item);
        item.setDateToString(DateToString.date(item.getMakeDate()));
        model.addAttribute("item", item);
        return "items/detailItem";
    }

    /**
     * 添加商品也跳转
     * @return 跳转的商品页面
     */
    @RequestMapping("addItem")
    public String addItem(){
        return "items/addItem";
    }

    /**
     * 根据ID删除商品
     * @param itemId 商品id
     */
    @RequestMapping("deleteItemByPrimaryKey")
    public boolean deleteItemByPrimaryKey(Integer itemId)throws Exception{
        adminService.deleteItemByPrimaryKey(itemId);
        return true;
    }

    /**
     * 批量删除商品
     * @param arrayString 商品id数组
     */
    @RequestMapping("deleteItemByIdArray")
    public boolean deleteItemByIdArray(String arrayString){
        List<Integer> list =new ArrayList<>();
        for (String uuid : arrayString.split(","))
            list.add(Integer.parseInt(uuid));
//        adminService.deleteIte(list.toArray(new Integer[list.size()]));
//        countGroups = null;
        return true;
    }

    @RequestMapping("editItem")
    public String editItem(Integer itemId,Model model) throws Exception{
        Item item = adminService.selectItemByPrimaryKey(itemId);
        System.out.println(item);
        item.setDateToString(DateToString.date(item.getMakeDate()));
        model.addAttribute("item", item);
        return "items/editItem";
    }

}
