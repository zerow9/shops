package com.coding.serviceImpl;

import com.coding.Iservice.IindexItemService;
import com.coding.Lucene.LuceneContext;
import com.coding.Lucene.SearchField;
import com.coding.mapper.ItemIndexMapper;
import com.coding.mapper.ItemMapper;
import com.coding.pojo.Item;
import com.coding.pojo.ItemIndex;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("indexService")
public class IndexService implements IindexItemService {
    @Autowired
    private ItemIndexMapper indexMapper;
    @Autowired
    private ItemMapper itemMapper;

    private final static String DEL = "delete";
    private final static String ADD = "insert";
    private final static String UPDATE = "update";

    @Transactional(rollbackFor =Exception.class )
    public void addIndex(Item fields, boolean inDatabase)throws Exception{
        try {
            if (inDatabase){
                ItemIndex index = new ItemIndex();
                index.setItemId(fields.getItemId());
                index.setIndexType(ADD);
                indexMapper.insertItemIndexSelective(index);
            }
            NRTManager nrtManager = LuceneContext.getInstance().getNrtManager();
            Document doc = filedDoc(fields);
            nrtManager.addDocument(doc);
            updateCommitIndex(); //提交索引，待优化
        } catch (Exception e) {
            throw e;
        }
    }
    private Document filedDoc(Item fields)throws Exception{
        Document doc = new Document();
//        doc.add(new NumericField("id",Field.Store.YES,true).setIntValue(fields.getItemId()));
        doc.add(new Field("id",fields.getItemId().toString(),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
        doc.add(new Field("name",fields.getItemName(),Field.Store.YES,Field.Index.ANALYZED));
        doc.add(new Field("keyword",fields.getKeyWord(),Field.Store.YES,Field.Index.ANALYZED));
        doc.add(new Field("images",fields.getItemImages(),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
        doc.add(new Field("introduce",fields.getItemIntroduce(),Field.Store.NO,Field.Index.ANALYZED_NO_NORMS));
        doc.add(new NumericField("price",Field.Store.YES,true).setDoubleValue(fields.getItemMarketPrice()));
        return doc;
    }

    @Transactional(rollbackFor =Exception.class )
    public void deleteIndex(Integer id,boolean inDatabase)throws Exception{
        try {
            if(inDatabase){
            ItemIndex index = new ItemIndex();
            index.setItemId(id);
            index.setIndexType(DEL);
            indexMapper.insertItemIndexSelective(index);
            }
            LuceneContext.getInstance().getNrtManager().deleteDocuments(new Term("id",id.toString()));
            updateCommitIndex(); //提交索引，待优化
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateIndex(Item fields, boolean inDatabase)throws Exception{
        if(inDatabase){
        ItemIndex index = new ItemIndex();
        index.setItemId(fields.getItemId());
        index.setIndexType(UPDATE);
        indexMapper.insertItemIndexSelective(index);
        }
        NRTManager nrtManager = LuceneContext.getInstance().getNrtManager();
        Document doc = filedDoc(fields);
        try {
            nrtManager.updateDocument(new Term("id",fields.getItemId().toString()),doc);
            updateCommitIndex(); //提交索引，待优化
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Item> findByIndex(SearchField field)throws Exception{
        List<Item> items = new ArrayList<>();
        IndexSearcher searcher = LuceneContext.getInstance().getSearcher();
        try {
            MultiFieldQueryParser parser = new MultiFieldQueryParser(LuceneContext.getInstance().getVersion(),
                    new String[]{"name","keyword","introduce"}, LuceneContext.getInstance().getAnalyzer());
            Query query = parser.parse(field.getCondition());
            TopDocs tds = searcher.searchAfter(getLastDoc(field.getIndexNumber(),field.getPageNumber(),searcher,query),query,field.getPageNumber());
            for(ScoreDoc sd:tds.scoreDocs){
                Document doc = searcher.doc(sd.doc);
                Item item =new Item();
                item.setItemId(Integer.valueOf(doc.get("id")));
                item.setItemName(doc.get("name"));
                item.setItemImages(doc.get("images"));
                item.setItemPrice(Double.valueOf(doc.get("price")));
                item.setKeyWord(doc.get("keyword"));
                items.add(item);
            }
            return items;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            LuceneContext.getInstance().releaseSearcher(searcher);
        }
        return null;
    }
    private ScoreDoc getLastDoc(int indexNum,int pageNum,IndexSearcher searcher,Query query){
        if (indexNum==0) return null;
        try {
            TopDocs tds =searcher.search(query,indexNum*pageNum);
            return tds.scoreDocs[(indexNum*pageNum)-1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Integer getDocCount(SearchField field)throws Exception{
        IndexSearcher searcher = LuceneContext.getInstance().getSearcher();
        try {
            MultiFieldQueryParser parser = new MultiFieldQueryParser(LuceneContext.getInstance().getVersion(),
                    new String[]{"name","keyword","introduce"}, LuceneContext.getInstance().getAnalyzer());
            Query query = parser.parse(field.getCondition());
            TopDocs tds =searcher.search(query,1);
            return tds.totalHits;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Transactional(rollbackFor =Exception.class )
    public void updateCommitIndex() throws Exception {
        indexMapper.deleteItemIndexAll();
        LuceneContext.getInstance().commitIndex();
    }
    @Transactional(rollbackFor =Exception.class )
    public void updateSetIndex() throws Exception {
        /**
         * 将数据库所用对象取出，创建相应的IndexField完成索引的重构
         */
        List<ItemIndex> itemIndices = indexMapper.selectItemIndexAll();
        indexMapper.deleteItemIndexAll();
        indexItemList(itemIndices);
        LuceneContext.getInstance().commitIndex();
    }

    private void indexItemList(List<ItemIndex> itemIndices) throws Exception {
        for(ItemIndex index:itemIndices){
            Item field = itemMapper.selectItemByPrimaryKey(index.getItemId());
            if(field !=null){
            if(index.getIndexType().contains("insert"))
                addIndex(field,false);
            if(index.getIndexType().contains("delete"))
                deleteIndex(field.getItemId(),false);
            if(index.getIndexType().contains("update"))
                updateIndex(field,false);
         }
        }
    }

    public void updateReconstructorIndex() throws Exception {
        LuceneContext.getInstance();
        LuceneContext.getWriter().deleteAll();
        List<Item> items = itemMapper.selectItemAll();
        for(Item item:items){
            addIndex(item,false);
        }
        LuceneContext.getInstance().commitIndex();
        indexMapper.deleteItemIndexAll();
//        LuceneContext.getWriter().close();
    }


}

