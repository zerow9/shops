package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.json.JsonFormat;
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

    @Autowired
    private IAdminService adminService;

    @RequestMapping("forwardVenders")
    public String forwardVenders() {
        return "venders/listVender";
    }

    @RequestMapping("getVenderJson")
    @ResponseBody
    public String getVenderJson(Integer page, Integer limit) throws Exception {
        List<Vender> venders = adminService.selectVenderAll();
        JsonFormat<Vender> json = new JsonFormat<>(venders, venders.size(), null, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
    }

    @RequestMapping("deleteVenderByPrimaryKey")
    public boolean deleteVenderByPrimaryKey(Integer venderId) throws Exception {
        adminService.deleteVenderByPrimaryKey(venderId);
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
    public boolean updateVenderaction(Vender vender) throws Exception {
        adminService.updateVenderByPrimaryKey(vender);
        return true;
    }

    @RequestMapping("insertyVenderaction")
    public boolean insertyVenderaction(Vender vender) throws Exception {
        adminService.insertVender(vender);
        return true;
    }

    @RequestMapping("addVender")
    public String addVender(){
        return "venders/addVender";
    }

}
