package com.coding.serviceImpl;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.coding.Iservice.FileService;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;

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
        bucketName = "xcstudio";
        endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        accessKeyId = "LTAItV2D26rhST1y";
        accessKeySecret = "A7RIc9aGRI1YIScwra1B2yQt67ZvAS";
    }

    /**
     * 获取OSSClient实例
     *
     * @return OSSClient
     */
    public OSSClient getOSSClient() {
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
        boolean exists = ossClient.doesObjectExist(bucketName, fileName);
        StrBuilder msg = new StrBuilder("文件：“" + fileName + "”");
        if (exists) {
            msg.append("存在");
        } else {
            msg.append("不存在");
        }
        System.out.println(msg);

        if (exists) {
            // 设置文件访问权限
            // ossClient.setObjectAcl(bucketName, key, CannedAccessControlList.privateRead);
            // ossClient.setObjectAcl(bucketName, key, CannedAccessControlList.Default);

            // 获取文件访问权限
            ObjectAcl objectAcl = ossClient.getObjectAcl(bucketName, fileName);
            System.out.println("文件" + fileName + "的访问权限为:" + objectAcl.getPermission().toString());
        }
        ossClient.shutdown();
        return exists;
    }

    /**
     * 上传文件，如果发现同名文件，则服务器上的同名文件会被覆盖
     *
     * @return String url 文件访问地址
     */
    public String putObject(InputStream inputStream, String fileName) {
        OSSClient ossClient = getOSSClient();
//        String fileName = "test.txt";
        System.out.println("开始上传文件：" + fileName);
//        try {
        // 上传文件流
        // inputStream inputStream = new FileInputStream("D:\\MyZone\\Pictures\\background-img\\bg1121.jpg");
        ossClient.putObject(bucketName, fileName, inputStream);
        // 上传网络流
        // InputStream inputStreamNet = new URL("https://www.baidu.com/img/bd_logo1.png").openStream();
        // ossClient.putObject(bucketName, "bd_logo1.png", inputStreamNet);
        // 上传本地文件
        // ossClient.putObject(bucketName, "bg1121.jpg", new File("D:\\MyZone\\Pictures\\background-img\\bg1121.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 设置文件访问权限，默认继承痛的权限
        ossClient.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);
        System.out.println("文件" + fileName + "上传成功。");
        ossClient.shutdown();
        return getUrl(fileName);
    }

    /**
     * 下载文件
     */
    public void getFile(String fileName) {
        OSSClient ossClient = getOSSClient();
        System.out.println("开始下载文件：" + fileName);
        OSSObject object = ossClient.getObject(bucketName, fileName);
        System.out.println("文件" + fileName + "下载成功。");
        System.out.println("文件类型: " + object.getObjectMetadata().getContentType());
        displayTextInputStream(object.getObjectContent());
        ossClient.shutdown();
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
     * @return url
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
     * @return url
     */
    public String getUrl(String fileName) {
        return endpoint.replace("http://", "http://" + bucketName + ".") + "/" + fileName;
    }

    // ==================================begin：辅助方法====================================

    //  创建示例文件
    private File createSampleFile() {
        File file = null;
        try {
            file = File.createTempFile("oss-java-sdk-", ".txt");
            file.deleteOnExit();
            Writer writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write("hello\n");
            writer.write("world\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    // 读文件内容
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
}
