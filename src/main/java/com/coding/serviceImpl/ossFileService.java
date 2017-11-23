package com.coding.serviceImpl;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.coding.Iservice.FileService;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 阿里云对象存储（OSS）接口实现
 * java 版本
 */
@Service("ossFileService")
public class ossFileService implements FileService {
    /**
     * bucket名
     */
    private String bucketName;
    /**
     * 访问域名和数据中心
     */
    private String endpoint;
    /**
     * 连接id
     */
    private String accessKeyId;
    /**
     * 连接key
     */
    private String accessKeySecret;

    /**
     * 初始化配置信息
     */
    public ossFileService() {
        bucketName = "xcstudio-shop";
        endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        accessKeyId = "LTAItV2D26rhST1y";
        accessKeySecret = "A7RIc9aGRI1YIScwra1B2yQt67ZvAS";
    }

    /**
     * 获取OSSClient实例
     *
     * @return OSSClient
     */
    private OSSClient getOSSClient() {
        logger.info("创建OSSClient");
        // 创建ClientConfiguration实例，用于对OSSClient进行配置
        ClientConfiguration conf = new ClientConfiguration();
        // 设置OSSClient使用的最大连接数，默认1024
        conf.setMaxConnections(200);
        // 设置请求超时时间，默认50秒
        conf.setSocketTimeout(10000);
        // 设置失败请求重试次数，默认3次
        conf.setMaxErrorRetry(5);
        // 创建OSSClient实例并返回

        return new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);
    }

    // ==================================begin：桶（bucket）操作====================================

    /**
     * 创建bucket
     */
    public void createBucket() {
        OSSClient ossClient = getOSSClient();
        if (!ossClient.doesBucketExist(bucketName)) {
            //如果不存在则创建一个bucket
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            ossClient.createBucket(bucketName);
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
            // 设置bucket权限为公共读，默认是私有读写
            // createBucketRequest.setCannedACL(CannedAccessControlList. privateRead);
            // 设置bucket存储类型为低频访问类型，默认是标准类型
            //createBucketRequest.setStorageClass(StorageClass.IA);
            ossClient.createBucket(createBucketRequest);
        } else {
            System.out.println("Bucket：" + bucketName + "已近存在，跳过创建。");
        }
        ossClient.shutdown();
    }

    /**
     * 列出所有bucket
     *
     * @param prefix 关键字
     *               / * @param maxKeys 列出最大数量
     * @return buckets
     */
    public List<Bucket> listBuckets(String prefix) {
        OSSClient ossClient = getOSSClient();
        System.out.println("列出所有bucket");
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 限定返回的Bucket name必须以prefix作为前缀，可以不设定，不设定时不过滤前缀信息
        listBucketsRequest.setPrefix(prefix);
        // 限定此次返回Bucket的最大数，如果不设定，默认为100，max-keys取值不能大于1000
//        listBucketsRequest.setMaxKeys(maxKeys);
        // 列举bucket
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }
        System.out.println();
        ossClient.shutdown();
        return buckets;
    }

    // ==================================begin：文件操作====================================

    /**
     * 判断文件是否在bucket中
     */
    public boolean hasFile(String fileName) {
        OSSClient ossClient = getOSSClient();
        boolean exists = false;
        try {
            exists = ossClient.doesObjectExist(bucketName, fileName);
        } catch (OSSException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return exists;
    }

    /**
     * 上传文件，如果发现同名文件，则服务器上的同名文件会被覆盖
     *
     * @param inputStream 文件流
     * @param fileName    文件名
     * @return String Url 文件访问地址
     */
    public String uploadFile(InputStream inputStream, String fileName) {
        OSSClient ossClient = getOSSClient();
        try {
            ossClient.putObject(bucketName, fileName, inputStream);
            // 设置文件访问权限，默认继承痛的权限
            ossClient.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
            System.out.println("文件" + fileName + "上传成功。");
        } catch (OSSException e) {
            e.printStackTrace();
        } finally {
            closeResources(inputStream, ossClient);
        }
        return getUrl(fileName);
    }

    /**
     * * 上传网络文件，如果发现同名文件，则服务器上的同名文件会被覆盖
     *
     * @param netUrl   网络文件地址
     * @param filePath 文件存储路径
     * @return String netUrl 文件访问地址
     * @throws Exception 当网络地址无效时会抛出议程
     */
    public String uploadNetFile(String netUrl, String filePath) throws Exception {
        OSSClient ossClient = getOSSClient();
        String fileName = getFileName(netUrl);
        if (fileName != null) {
            try {
                fileName = filePath + getFileName(netUrl);
                // 上传网络流
                InputStream inputStreamNet = new URL(netUrl).openStream();
                ossClient.putObject(bucketName, fileName, inputStreamNet);
                // 设置文件访问权限，默认继承痛的权限
                ossClient.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
                System.out.println("文件" + fileName + "上传成功。");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                ossClient.shutdown();
            }
        } else {
            throw new Exception("上传失败，请检查你的网络文件地址是否有效！");
        }
        return getUrl(fileName);
    }

    /**
     * 下载文件
     */
    public void getFile(String fileName) {
        OSSClient ossClient = getOSSClient();
        try {
            System.out.println("开始下载文件：" + fileName);
            OSSObject object = ossClient.getObject(bucketName, fileName);
            System.out.println("文件" + fileName + "下载成功。");
            System.out.println("文件类型: " + object.getObjectMetadata().getContentType());
        } catch (OSSException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }

    /**
     * 删除文件
     */
    public void deleteFile(String fileName) {
        OSSClient ossClient = getOSSClient();
        System.out.println("开始删除文件：" + fileName);
        ossClient.deleteObject(bucketName, fileName);
        System.out.println("文件" + fileName + "删除成功。");
        ossClient.shutdown();
    }

    /**
     * 列出所有文件
     *
     * @param prefix 关键字
     */
    public void listFile(String prefix) {
        OSSClient ossClient = getOSSClient();
        System.out.println("bucket：" + bucketName + " 中的所有文件如下：");
        ObjectListing objectListing = ossClient.listObjects(bucketName, prefix);
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        System.out.println();
        ossClient.shutdown();
    }

    /**
     * 获取文件防盗链地址
     *
     * @param fileName 文件名
     * @return netUrl
     */
    public URL generatePresignedUrl(String fileName) {
        OSSClient ossClient = getOSSClient();
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
        logger.debug("文件“" + fileName + "”的防盗链URL为：" + url);
        ossClient.shutdown();
        return url;
    }

    /**
     * 获取文件访问地址
     *
     * @param fileName 文件名
     * @return netUrl
     */
    public String getUrl(String fileName) {
        return endpoint.replace("http://", "http://" + bucketName + ".") + "/" + fileName;
    }

    // ==================================begin：辅助方法====================================

    /**
     * 读取文件内容
     *
     * @param input 文件流
     */
    private void displayTextInputStream(InputStream input) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("    " + line);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件路径获取文件名
     *
     * @param str 文件路径
     * @return fileName
     */
    private String getFileName(String str) {
        //支持的文件格式结合
        String fileExtension = "bmp|dib|pcp|dif|wmf|gif|jpg|tif|eps|psd|cdr|iff|tga|pcd|mpt|png|3g2|3gp|3gp2|3gpp|amv|asf|avi|bik|bin|divx|drc|dv|f4v|flv|gvi|gxf|iso|m1v|m2v|m2t|m2ts|m4v|mkv|mov|mp4|mp4v|mpe|mpeg|mpeg1|mpeg2|mpeg4|mpg|mpv2|mts|mxf|mxg|nsv|nuv|ogg|ogm|ogv|ps|rec|rm|rmvb|rpl|thp|tod|ts|tts|txd|vob|vro|webm|wm|wmv|wtv|xesc|3ga|669|a52|acc|ac3|adt|adts|aif|aiff|amr|aob|ape|awb|caf|dts|flac|it|kar|m4a|m4b|m4p|m5p|mid|mka|mlp|mod|mpa|mp1|mp2|mp3|mpc|mpga|mus|oga|ogg|oma|opus|qcp|ra|rmi|s3m|sid|spx|thd|tta|voc|vqf|w64|wav|wma|wv|xa|xm";
        fileExtension += "|" + fileExtension.toUpperCase();
        // 按指定模式在字符串查找
        String pattern = ".+/(.*\\.(" + fileExtension + "))";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(str);
        if (m.find()) {
            return m.group(1);
        } else {
            System.out.println("该地址：”" + str + "“无法获取文件名");
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @param inputStream 文件流
     * @return 关闭状态
     */
    private boolean closeResources(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 释放资源
     *
     * @param inputStream 文件流
     * @return 关闭状态
     */
    private boolean closeResources(InputStream inputStream, OSSClient ossClient) {
        if (inputStream != null) {
            if (!closeResources(inputStream)) {
                return false;
            }
        }
        if (ossClient != null) {
            ossClient.shutdown();
        }
        return true;
    }
}
