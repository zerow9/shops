package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.json.JsonFormat;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomVender;
import com.coding.pojo.Vender;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("venders")
public class VendersController {

    private Integer counts;

    @Autowired
    private IAdminService adminService;

    @RequestMapping("forwardVenders")
    public String forwardVenders() {
        return "venders/listVender";
    }

    @RequestMapping("getVenderJson")
    @ResponseBody
    public String getVenderJson(Integer page, Integer limit) throws Exception {
        PagingCustomVender pagingCustom = new PagingCustomVender();
        pagingCustom.setIndexNumber((page - 1) * limit);
        pagingCustom.setPageNumber(limit);
        if (page == 1 && counts == null)
            counts = adminService.selectVenderCount();
        List<Vender> venders = adminService.selectVender(pagingCustom);
        MyJsonConfig<Vender> myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(venders, counts);
    }

    @RequestMapping("deleteVenderByPrimaryKey")
    public boolean deleteVenderByPrimaryKey(Integer venderId) throws Exception {
        adminService.deleteVenderByPrimaryKey(venderId);
        counts--;
        return true;
    }

    @RequestMapping("seeVenderIdByKey")
    public String seeVenderIdByKey(HttpSession session, Integer venderId) throws Exception {
        Vender vender = adminService.selectVenderByPrimaryKey(venderId);
        session.setAttribute("vender", vender);
        return "venders/detailVender";
    }

    @RequestMapping("updateVender")
    public String updateVender(HttpSession session, Integer venderId) throws Exception {
        Vender vender = adminService.selectVenderByPrimaryKey(venderId);
        session.setAttribute("vender", vender);
        return "venders/editVender";
    }

    @RequestMapping("updateVenderaction")
    @ResponseBody
    public boolean updateVenderaction(Vender vender) throws Exception {
        adminService.updateVenderByPrimaryKey(vender);
        return true;
    }

    @RequestMapping("insertyVenderaction")
    @ResponseBody
    public boolean insertyVenderaction(Vender vender) throws Exception {
        adminService.insertVender(vender);
        counts++;
        return true;
    }

    @RequestMapping("addVender")
    public String addVender() {
        return "venders/addVender";
    }

    @RequestMapping("deleteVenderByIdArray")
    public boolean deleteVenderByIdArray(String arrayString) throws Exception {
        String[] strings = arrayString.split(",");
        Integer integer[] = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integer[i] = Integer.valueOf(strings[i]);
        }
        counts-=strings.length;
        adminService.deleteVenderByPrimaryKeyArray(integer);
        return true;
    }

}
