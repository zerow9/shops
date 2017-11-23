package com.coding.controller;

import com.coding.serviceImpl.ossFileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileController {

    private Logger logger = Logger.getLogger(FileController.class);

    /**
     * 自动装配文件处理服务
     */
    @Resource
    private ossFileService ossFileService;

    /**
     * 文件上传
     *
     * @param uploadFile 文件流
     * @return json
     */
    @ResponseBody
    @RequestMapping("uploadFile")
    public Map<String, Object> uploadFile(MultipartFile uploadFile) {

        int code = 0;        //状态码：0为正常，非零为不正常
        String msg = "";        //返回的提示信息
        Map<String, Object> result = new HashMap<>();       //返回文件上传结果
        Map<String, Object> dataItem = new HashMap<>();     //封装文件访问URL到data
        if (uploadFile != null) {   //当文件流不为空时才会执行文件上传操作
            String filePath = "img/";       //文件上传路径（文件夹）
            String fileSimpleName = uploadFile.getOriginalFilename();       //获取文件名
            String fileName = filePath + fileSimpleName;       //文件全名，包含路径
            InputStream inputStream = null;
            try {
                inputStream = uploadFile.getInputStream();      //获取上传的文件流
                String url = ossFileService.uploadFile(inputStream, fileName);      //开始上传文件
                dataItem.put("src", url);
                msg = "文件：" + fileSimpleName + "上传成功！文件URL为：" + url;
            } catch (Exception e) {
                e.printStackTrace();
                code = 1;
                msg = "文件" + fileSimpleName + "上传失败！";
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            msg = "请先选择你要上传的文件！";
        }
        System.out.println("提示信息：" + msg);
        logger.info("提示信息：" + msg);
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", dataItem);
        return result;
    }

    /**
     * 网络文件上传
     *
     * @param netUrl 网络文件地址
     * @return json
     */
    @ResponseBody
    @RequestMapping("uploadNetFile")
    public Map<String, Object> uploadNetFile(String netUrl) {

        int code = 0;        //状态码：0为正常，非零为不正常
        String msg = "";        //返回的提示信息
        Map<String, Object> result = new HashMap<>();       //返回文件上传结果
        Map<String, Object> dataItem = new HashMap<>();     //封装文件访问URL到data
        if (netUrl != null) {   //当文件流不为空时才会执行文件上传操作
            String filePath = "img/";       //文件上传路径（文件夹）
            try {
                String url = ossFileService.uploadNetFile(netUrl, filePath);  //开始上传文件
                dataItem.put("src", url);
                msg = "文件上传成功！文件URL为：" + url;
            } catch (Exception e) {
                e.printStackTrace();
                code = 1;
                msg = "文件上传失败！";
            }
        } else {
            msg = "请先输入你要上传的文件地址！";
        }
        System.out.println(msg);
        logger.info(msg);
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", dataItem);
        return result;
    }

}
