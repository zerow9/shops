package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.paging.PagingCustomRepertory;
import com.coding.pojo.ItemType;
import com.coding.pojo.Repertory;
import com.coding.json.JsonFormat;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("repertories")
public class repertoriesController {

    private Integer counts = null;

    @Autowired
    private IAdminService adminService;

    @RequestMapping("forwardRepertories")
    public String forwardRepertories() {
        return "repertories/listRepertory";
    }

    @RequestMapping("getRepertoryAll")
    @ResponseBody
    public String getRepertoryAll(Integer page, Integer limit) throws Exception {
        PagingCustomRepertory pagingCustomItemType = new PagingCustomRepertory();
        pagingCustomItemType.setIndexNumber((page - 1) * limit);
        pagingCustomItemType.setPageNumber(limit);
        if ((page == 1 && counts == null) || counts == null)
            counts = adminService.selectRepertoryCount();
        List<Repertory> items = adminService.selectRepertory(pagingCustomItemType);
        for (Repertory repertory : items) {
            repertory.setUpdateToString(DateToString.date(repertory.getUpdateTime()));
            repertory.setPuttimeToString(DateToString.date(repertory.getRepertoryPuttime()));
        }
        JsonFormat<Repertory> json = new JsonFormat<>(items, counts, null, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
    }

    @RequestMapping("deleteRepertoryByIdArray")
    public boolean deleteRepertoryByIdArray(String arrayString) {
        // adminService.deleteRepertoryByPrimaryKey();
        return true;
    }

    @RequestMapping("deleteRepertoryIdByPrimaryKey")
    public boolean deleteRepertoryIdByPrimaryKey(Integer repertoryId) throws Exception {
        adminService.deleteRepertoryByPrimaryKey(repertoryId);
        counts--;
        return true;
    }

    @RequestMapping("detailRepertory")
    public String detailRepertory(HttpSession session, Integer repertoryId) throws Exception {
        Repertory repertory = adminService.selectRepertoryByPrimaryKey(repertoryId);
        repertory.setUpdateToString(DateToString.date(repertory.getUpdateTime()));
        repertory.setPuttimeToString(DateToString.date(repertory.getRepertoryPuttime()));
        session.setAttribute("repertory", repertory);
        return "repertories/detailRepertories";
    }

    @RequestMapping("editRepertory")
    public String editRepertory(HttpSession session, Integer repertoryId) throws Exception {
        Repertory repertory = adminService.selectRepertoryByPrimaryKey(repertoryId);
        repertory.setUpdateToString(DateToString.date(repertory.getUpdateTime()));
        repertory.setPuttimeToString(DateToString.date(repertory.getRepertoryPuttime()));
        session.setAttribute("repertory", repertory);
        return "repertories/updateRepertories";
    }

    @RequestMapping("updateRepertoryId")
    public boolean updateRepertoryId(Repertory repertory) throws Exception {
        adminService.updateRepertoryByPrimaryKey(repertory);
        return true;
    }

    @RequestMapping("addRepertory")
    public String addRepertory() {
        return "repertories/addRepertory";
    }

    @RequestMapping("insertRepertory")
    public boolean insertRepertory(Repertory repertory) throws Exception {
        adminService.insertRepertory(repertory);
        counts++;
        return true;
    }

}
