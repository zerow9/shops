package com.coding.Lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

public class LuceneContext {
    private  static  LuceneContext instance;
    private static IndexWriter writer;
    private static  Analyzer analyzer ;
    private static Version version;
    private static NRTManager nrtManager;
    private static SearcherManager mgr;
    private static Directory directory;
    //无参构造函数
    private  LuceneContext(){ }
    //单列设计模式
    public static LuceneContext getInstance() throws IOException {
        if(instance==null) instance = new LuceneContext();
        init();
        return instance;
    }

    //单列初始化操作
    private static void init() throws IOException {
        String dicUrl = new File(".").getCanonicalPath()+File.separator+"index";
//        System.out.println(dicUrl);
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
}
