package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomNotice;
import com.coding.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("notices")
public class NoticesController {

    private Integer counts = null;

    @Autowired
    private IAdminService adminService;

    @RequestMapping("noticesList")
    public String noticesList() {
        return "notices/listNotice";
    }

    @RequestMapping("getNotice")
    @ResponseBody
    public String getNotice(Integer page, Integer limit) throws Exception {
        PagingCustomNotice pagingCustomItemType = new PagingCustomNotice();
        pagingCustomItemType.setIndexNumber((page - 1) * limit);
        pagingCustomItemType.setPageNumber(limit);
        if (counts == null)
            counts = adminService.selectNoticeCount();
        List<Notice> items = adminService.selectNotice(pagingCustomItemType);
        MyJsonConfig<Notice> myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(items, counts);
    }

    @RequestMapping("deleteNoticeByPrimaryKey")
    public boolean deleteNoticeByPrimaryKey(Integer noticeId) throws Exception {
        adminService.deleteNoticeByPrimaryKey(noticeId);
        counts--;
        return true;
    }

    @RequestMapping("detailNoticeIdByKey")
    public String detailNoticeIdByKey(HttpServletRequest request, Integer noticeId) throws Exception {
        Notice notice = adminService.selectNoticeByPrimaryKey(noticeId);
        notice.setNoiceTimeToString(DateToString.date(notice.getNoiceTime()));
        request.setAttribute("notice", notice);
        return "notices/detailNotice";
    }

    @RequestMapping("editNotice")
    public String editNotice(HttpServletRequest request, Integer noticeId) throws Exception {
        Notice notice = adminService.selectNoticeByPrimaryKey(noticeId);
        notice.setNoiceTimeToString(DateToString.date(notice.getNoiceTime()));
        request.setAttribute("notice", notice);
        return "notices/editNotice";
    }

    @RequestMapping("deleteNoticeByIdArray")
    public boolean deleteNoticeByIdArray(String arrayString) throws Exception {
        String[] strings = arrayString.split(",");
        Integer integer[] = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integer[i] = Integer.parseInt(strings[i]);
        }
        adminService.deleteNoticeByPrimaryKeyArray(integer);
        counts-=strings.length;
        return true;
    }

    @RequestMapping("addNotice")
    public String addNotice(){
        return "notices/addNotice";
    }

    @RequestMapping("updateNotice")
    public  boolean updateNotice(String use,Notice notice)throws Exception{
        if(use==null){
            notice.setIsUse(0);
        }else {
            notice.setIsUse(1);
        }
        notice.setNoiceTime(new Date());
        adminService.updateNoticeByPrimaryKeySelective(notice);
        return true;
    }

    @RequestMapping("insertNotice")
    public boolean insertNotice(String use,Notice notice)throws Exception{
        System.out.println(111111);
        if(use==null){
            notice.setIsUse(0);
        }else {
            notice.setIsUse(1);
        }
        notice.setNoiceTime(new Date());
        adminService.insertNoticeSelective(notice);
        counts++;
        return true;
    }
}
