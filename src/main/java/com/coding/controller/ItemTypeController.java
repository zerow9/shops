package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.JavaGet;
import com.coding.json.MyJsonConfig;
import com.coding.pojo.ItemType;
import com.coding.paging.PagingCustomItemType;
import com.coding.json.JsonFormat;
import com.coding.pojo.ItemTypeDetail;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        List<ItemType> iteTmypes = adminService.selectItemType(pagingCustomItemType);

        List<ItemTypeDetail> itemTypeDetails=new ArrayList<ItemTypeDetail>();

        for (ItemType itemType:iteTmypes){
            ItemTypeDetail itemTypeDetail=new ItemTypeDetail();
            itemTypeDetail.setTypeKeyWord(itemType.getTypeKeyWord());
            itemTypeDetail.setTypeId(itemType.getTypeId());
            itemTypeDetail.setTypeName(itemType.getTypeName());
            itemTypeDetail.setFatherTypeId(itemType.getFatherTypeId());
            itemTypeDetail.setTypeLevel(itemType.getTypeLevel());
            itemTypeDetail.setTypeIntroduce(itemType.getTypeIntroduce());

            if (!(itemType.getFatherTypeId()==0)) {
                ItemType itemType1=adminService.selectItemTypeByPrimaryKey(itemType.getFatherTypeId());
                itemTypeDetail.setParentItemTypeName(itemType1.getTypeName());
            }else itemTypeDetail.setParentItemTypeName("无父类别");

            itemTypeDetails.add(itemTypeDetail);
        }


        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(itemTypeDetails, counts);
    }

    @RequestMapping("deleteGroupsByPrimaryKey")
    public boolean deleteGroupsByPrimaryKey(Integer typeId) throws Exception {
        adminService.deleteItemTypeByPrimaryKey(typeId);
        counts--;
        return true;
    }

    @RequestMapping("detailItemsTypeIdByKey")
    public String detailItemsTypeIdByKey(Model model, Integer typeId) throws Exception {
        ItemType itemType = adminService.selectItemTypeByPrimaryKey(typeId);
        model.addAttribute("itemtypes", itemType);

        //获取下拉列表
        PagingCustomItemType pagingCustomItemType=new PagingCustomItemType();
        List<ItemType> itemTypes=adminService.selectItemType(pagingCustomItemType);
        model.addAttribute("itemTypeLists",itemTypes);

        return "itemtypes/detailTypes";
    }

    @RequestMapping("editItemType")
    public String editItemType(HttpSession session, Integer typeId) throws Exception {
        ItemType itemType = adminService.selectItemTypeByPrimaryKey(typeId);
        session.setAttribute("itemtypes", itemType);

        PagingCustomItemType pagingCustomItemType=new PagingCustomItemType();
        List<ItemType> itemTypes=adminService.selectItemType(pagingCustomItemType);
        session.setAttribute("itemTypeLists",itemTypes);
        return "itemtypes/updateitemTypes";
    }

    @RequestMapping("updateItemTypeById")
    public boolean updateItemTypeById(ItemType itemType, HttpServletRequest request) throws Exception {

        //解决编码问题
        itemType.setTypeName(JavaGet.charsetGet(itemType.getTypeName(),request));
        itemType.setTypeKeyWord(JavaGet.charsetGet(itemType.getTypeKeyWord(),request));

        adminService.updateItemTypeByPrimaryKey(itemType);
        return true;
    }

    @RequestMapping("addItemType")
    public String addItemType(Model model) {
        PagingCustomItemType pagingCustomItemType=new PagingCustomItemType();
        try {
            List<ItemType> itemTypes=adminService.selectItemType(pagingCustomItemType);
            model.addAttribute("itemTypes",itemTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "itemtypes/itemtypesAdd";
    }

    @RequestMapping("insertItemtypesAdd")
    public boolean insertItemtypesAdd(ItemType itemType) throws Exception {
        adminService.insertItemType(itemType);
        counts++;
        return true;
    }

}
