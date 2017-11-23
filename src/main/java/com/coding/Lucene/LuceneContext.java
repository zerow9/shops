package com.coding.Lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class LuceneContext {
    private  static LuceneContext instance;
    private static IndexWriter writer;
    private static  Analyzer analyzer ;
    private static Version version;
    private static NRTManager nrtManager;
    private static SearcherManager mgr;
    private static Directory directory;
    //无参构造函数
    private LuceneContext(){ }
    //单列设计模式
    public static LuceneContext getInstance() throws Exception {
        if(instance==null) {
            instance = new LuceneContext();
            init();
        }
        return instance;
    }

    //单列初始化操作
    private static void init() throws Exception {
//        String dicUrl = new File(".").getCanonicalPath();
        String dicUrl = getPathname();
        if (dicUrl == null || dicUrl.equals("")) throw new Exception("索引库路径为空.");
        directory = FSDirectory.open(new File(dicUrl));
        version = Version.LUCENE_35;
        analyzer = new StandardAnalyzer(version);
        if(writer == null)
            writer = new IndexWriter(directory,new IndexWriterConfig(version,analyzer));
        nrtManager = new NRTManager(writer, new SearcherWarmer() {
            public void warm(IndexSearcher indexSearcher) throws IOException {
                System.out.println("reopen index");
            }
        });
        mgr = nrtManager.getSearcherManager(true);
        NRTManagerReopenThread reopenThread = new NRTManagerReopenThread(nrtManager,5.0,0.025);
        reopenThread.setName("NRTManage reopen thread");
        reopenThread.setDaemon(true);
        reopenThread.start();
    }
    private static String getPathname() throws IOException {
        Element element = null;
        File f = new File(LuceneContext.class.getClassLoader().getResource("").getPath()+File.separator+"lucene.xml");  //部署tomcat路径
//        File f = new File("lucene.xml");   //测试路径
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            Document dt = db.parse(f);
            element = dt.getDocumentElement();
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node1 = childNodes.item(i);
                if ("Lucene".equals(node1.getNodeName())) {
                    NodeList nodeDetail = node1.getChildNodes();
                    for (int j = 0; j < nodeDetail.getLength(); j++) {
                        Node detail = nodeDetail.item(j);
                        if ("path".equals(detail.getNodeName())) // 输出path
                            return detail.getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //获得searcher
    public IndexSearcher getSearcher(){
        return  mgr.acquire();
    }
    //关闭searcher
    public void releaseSearcher(IndexSearcher searcher){
        try {
            mgr.release(searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //writer提交操作
    public void  commitIndex(){
        try {
            writer.commit();
//            writer.forceMerge(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获得Nrtmanager
    public NRTManager getNrtManager(){
        return nrtManager;
    }

    public  Version getVersion(){
        return  version;
    }

    public Analyzer getAnalyzer(){
        return analyzer;
    }

    public static IndexWriter getWriter() {
        return writer;
    }
}
