package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.comomInterface.MyUUID;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomItem;
import com.coding.pojo.Item;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("item")
public class ItemController {

    private Integer counts = null;

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;

    /**
     * 查询商品列表信息
     *
     * @param page  第几页
     * @param limit 每页显示几个
     * @return 商品劣列表数据
     */

    @ResponseBody
    @RequestMapping("getItemsAll")
    public String getItemsAll(Integer page, Integer limit) throws Exception {
        PagingCustomItem pagingCustomItem = new PagingCustomItem();
        pagingCustomItem.setIndexNumber((page - 1) * limit);
        pagingCustomItem.setPageNumber(limit);
        if (page == 1 )
            counts = adminService.selectItemCount();
        List<Item> items = adminService.selectItem(pagingCustomItem);
        for (Item item : items)
            item.setDateToString(DateToString.date(item.getMakeDate()));
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(items, counts);
    }

    /**
     * 商品列表页的跳转
     *
     * @return 商品列表页
     */
    @RequestMapping("forwardItemList")
    public String forwardItemList() throws Exception {
        return "items/itemList";
    }

    /**
     * 获取商品详情页数据
     *
     * @param itemId 商品ID
     * @return 详情页数据
     */
    @RequestMapping("detailItemsIdByKey")
    public String detailItemsIdByKey(Integer itemId, Model model) throws Exception {
        Item item = adminService.selectItemByPrimaryKey(itemId);
        item.setDateToString(DateToString.date(item.getMakeDate()));
        model.addAttribute("item", item);
        return "items/detailItem";
    }

    /**
     * 添加商品也跳转
     *
     * @return 跳转的商品页面
     */
    @RequestMapping("addItem")
    public String addItem() {
        return "items/addItem";
    }

    /**
     * 根据ID删除商品
     *
     * @param itemId 商品id
     */
    @RequestMapping("deleteItemByPrimaryKey")
    public boolean deleteItemByPrimaryKey(Integer itemId) throws Exception {
        adminService.deleteItemByPrimaryKey(itemId);
        return true;
    }

    /**
     * 批量删除商品
     *
     * @param arrayString 商品id数组
     */
    @RequestMapping("deleteItemByIdArray")
    public boolean deleteItemByIdArray(String arrayString) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (String uuid : arrayString.split(","))
            list.add(Integer.parseInt(uuid));
        adminService.deleteItemByItemIdArray(list.toArray(new Integer[list.size()]));
        counts = counts - list.size();
        return true;
    }

    @RequestMapping("editItem")
    public String editItem(Integer itemId, HttpServletRequest request) throws Exception {
        Item item = adminService.selectItemByPrimaryKey(itemId);
        item.setDateToString(DateToString.date(item.getMakeDate()));
        request.getSession().setAttribute("item", item);
        return "items/editItem";
    }

    @RequestMapping("/updateItem")
    public boolean updateItem(Item item) throws Exception {
        adminService.updateItemByPrimaryKey(item);
        return true;
    }

    @RequestMapping("insertItem")
    public boolean insertItem(Item item) throws Exception {
        adminService.insertItem(item);
        return true;
    }
}
