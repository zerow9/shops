package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.json.JsonFormat;
import com.coding.json.MyJsonConfig;
import com.coding.paging.PagingCustomLog;
import com.coding.pojo.Admin;
import com.coding.pojo.Log;
import com.sun.org.apache.bcel.internal.generic.IADD;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 日志的Controller
 */
@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;

    /**
     * 跳转页面
     * @return log列表页面
     */
    @RequestMapping("forwordLog")
    public String forwordLog(){
        return "logs/listLog";
    }

    /**
     * 获取 JSON 数据
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping("getLogs")
    @ResponseBody
    public String  getLogInformation(Integer page, Integer limit) throws Exception {
        PagingCustomLog pagingCustomLog=new PagingCustomLog();
        pagingCustomLog.setIndexNumber((page-1)*limit);
        pagingCustomLog.setPageNumber(limit);
        int counts =adminService.selectLogCount();
        List<Log> logs=adminService.selectLog(pagingCustomLog);
        for (Log log:logs) {
                log.setDateToString(DateToString.date(log.getLogLandTime()));
        }
        MyJsonConfig<Log> myJsonConfig = new MyJsonConfig<>();
        return myJsonConfig.start(logs, counts);
    }

    @RequestMapping("detail")
    public String detileLog(Integer logId, Model model){
        try {
            Log log=adminService.selectLogByPrimaryKey(logId);
            model.addAttribute("log",log);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "logs/detailLog";
    }
}
