package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.Iservice.IUserService;
import com.coding.comomInterface.DateToString;
import com.coding.pojo.Complaint;
import com.coding.paging.PagingCustomComplaint;
import com.coding.pojo.templet.JsonFormat;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("complaint")
public class ComplaintController {

    private Integer complaintCount = null;

    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;


    @RequestMapping("selectComplaintAll")
    public String selectComplaintAll() {
        return "complaint/complaintsList";
    }

    @RequestMapping("deleteComplaintId")
    public boolean deleteComplaintId(Integer complaintId) throws Exception {
        userService.deleteComplaintByPrimaryKey(complaintId);
        return true;
    }

    @RequestMapping("getComplaintJson")
    @ResponseBody
    public String getUserAll(Integer page, Integer limit) throws Exception {
        if (page == 1 && complaintCount == null)
            complaintCount = adminService.selectComplaintCount();
        PagingCustomComplaint complaint = new PagingCustomComplaint();
        complaint.setPageNumber(limit);
        complaint.setIndexNumber((page - 1) * limit);
        List<Complaint> complaints = adminService.selectComplaint(complaint);
        for (Complaint comp : complaints) {
            comp.setStatus(false);
            comp.setDateToString(DateToString.date(comp.getComplaintDate()));
        }
        JsonFormat<Complaint> json = new JsonFormat<>(complaints, complaintCount, null, null);
        JSONObject result = JSONObject.fromObject(json);
        return result.toString();
    }

    @RequestMapping("seeComplaintIdByKey")
    public String seeComplaintIdByKey(Integer complaintId, Model model) throws Exception {
        Complaint complaints = userService.selectComplaintByPrimaryKey(complaintId);
        complaints.setDateToString(DateToString.date(complaints.getComplaintDate()));
        model.addAttribute("complaint", complaints);
        return "complaint/detailComplaint";
    }

    @RequestMapping("addComplaint")
    public String addComplaint() throws Exception {
        return "complaint/addComplaint";
    }

    @RequestMapping("insertComplaint")
    public boolean insertComplaint(Complaint complaint) throws Exception {
        complaint.setComplaintDate(new Date());
        complaint.setIsDeal(0);
        userService.insertComplaintSelective(complaint);
        return true;
    }
}

