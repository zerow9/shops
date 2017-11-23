package com.coding.Iservice;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * 文件服务接口
 * <p>
 * 包含了文件上传、下载，修改、查询等操作，如果你要实现该接口，
 * 不管云服务器还是对象存储的文件服务，都要包含这些基本功能
 */
public interface FileService {

    /**
     * 日志服务
     */
    Logger logger = Logger.getLogger(FileService.class);

    // ==================================begin：文件操作====================================

    /**
     * 判断文件是否存在
     */
    boolean hasFile(String fileName);

    /**
     * 上传文件
     *
     * @return String url 文件访问地址
     */
    String uploadFile(InputStream inputStream, String fileName);

    /**
     * 下载文件
     */
    void getFile(String fileName);

    /**
     * 删除文件
     */
    void deleteFile(String fileName);

    /**
     * 列出所有文件
     *
     * @param prefix 关键字
     */
    void listFile(String prefix);

    /**
     * 获取文件访问地址
     *
     * @param fileName 文件名
     * @return url
     */
    String getUrl(String fileName);

}
