package com.coding.Iservice;


import com.coding.Lucene.SearchField;
import com.coding.pojo.Item;

import java.util.List;

public interface IindexItemService {

        public void addIndex(Item fields, boolean in)throws Exception;

        public void deleteIndex(Integer id, boolean inDatabase)throws Exception;

        public void updateIndex(Item fields, boolean inDatabase)throws Exception;


        public List<Item> findByIndex(SearchField field)throws Exception;
        /**
         * 提交索引,仅仅是从内存中提交
         */
        public void updateCommitIndex()throws Exception;
        /**
         * 重构索引
         */
        public void updateReconstructorIndex()throws Exception;
        /**
         * 设置索引，将数据库中没有添加为索引的对象完全添加
         */
        public void updateSetIndex()throws Exception;
}
