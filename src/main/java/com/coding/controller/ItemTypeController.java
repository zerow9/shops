package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.json.MyJsonConfig;
import com.coding.pojo.ItemType;
import com.coding.paging.PagingCustomItemType;
import com.coding.json.JsonFormat;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("itemType")
public class ItemTypeController {

    private Integer counts = null;

    @Autowired
    private IAdminService adminService;

    @RequestMapping("forwardItemTypeList")
    public String forwardItemTypeList() {
        return "itemtypes/itemtypesList";
    }

    @RequestMapping("getitemTypes")
    @ResponseBody
    public String getitemTypes(Integer page, Integer limit) throws Exception {
        PagingCustomItemType pagingCustomItemType = new PagingCustomItemType();
        pagingCustomItemType.setIndexNumber((page - 1) * limit);
        pagingCustomItemType.setPageNumber(limit);
        if (counts == null)
            counts = adminService.selectItemTypeCount();
        List<ItemType> items = adminService.selectItemType(pagingCustomItemType);
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(items, counts);
    }

    @RequestMapping("deleteGroupsByPrimaryKey")
    public boolean deleteGroupsByPrimaryKey(Integer typeId) throws Exception {
        adminService.deleteItemTypeByPrimaryKey(typeId);
        counts--;
        return true;
    }

    @RequestMapping("detailItemsTypeIdByKey")
    public String detailItemsTypeIdByKey(HttpSession session, Integer typeId) throws Exception {
        ItemType itemType = adminService.selectItemTypeByPrimaryKey(typeId);
        session.setAttribute("itemtypes", itemType);
        return "itemtypes/detailTypes";
    }

    @RequestMapping("editItemType")
    public String editItemType(HttpSession session, Integer typeId) throws Exception {
        ItemType itemType = adminService.selectItemTypeByPrimaryKey(typeId);
        session.setAttribute("itemtypes", itemType);
        return "itemtypes/updateitemTypes";
    }

    @RequestMapping("updateitemTypes")
    public boolean updateitemTypes(ItemType itemType) throws Exception {
        adminService.updateItemTypeByPrimaryKey(itemType);
        return true;
    }

    @RequestMapping("addItemType")
    public String addItemType() {
        return "itemtypes/itemtypesAdd";
    }

    @RequestMapping("insertItemtypesAdd")
    public boolean insertItemtypesAdd(ItemType itemType) throws Exception {
        adminService.insertItemType(itemType);
        counts++;
        return true;
    }

}
