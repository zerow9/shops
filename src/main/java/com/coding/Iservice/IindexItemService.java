package com.coding.Iservice;


import com.coding.Lucene.SearchField;
import com.coding.pojo.Item;

import java.util.List;

public interface IindexItemService {

        /**
         * 增加索引信息
         * @param fields 商品信息，
         * @param inDatabase    是否进行数据库索引操作备份
         * @throws Exception Lucene异常
         */
        public void addIndex(Item fields,boolean inDatabase)throws Exception;

        /**
         * 删除索引信息
         * @param id  商品ID
         * @param inDatabase 是否进行数据库索引操作备份
         * @throws Exception Lucene异常
         */
        public void deleteIndex(Integer id,boolean inDatabase)throws Exception;

        /**
         * 修改索引信息
         * @param fields 需要修改的商品对象
         * @param inDatabase 是否进行数据库索引操作备份
         * @throws Exception Lucene异常
         */
        public void updateIndex(Item fields,boolean inDatabase)throws Exception;

        /**
         * 根据自定义搜索对象查找索引
         * @param field 自定义的搜索对象
         * @return      返回List的Item商品
         * @throws Exception Lucene异常
         */
        public List<Item> findByIndex(SearchField field)throws Exception;

        /**
         * 得到所搜索的结果数量
         * @param field  搜索的对象
         * @return       结果数量
         * @throws Exception Lucene异常
         */
        public Integer getDocCount(SearchField field)throws Exception;

        /**
         * 提交索引,仅仅是从内存中提交(因并非同一项目，用不上)
         * @throws Exception
         */
        public void updateCommitIndex()throws Exception;

        /**
         * 如果有进行数据库备份，当系统挂掉，但是没有进行索引提交的时候可以启用
         * 设置索引，将数据库中没有添加为索引的对象完全添加
         * @throws Exception Lucene异常
         */
        public void updateSetIndex()throws Exception;

        /**
         * 删除原有索引，将数据库所有商品取出，重新进行索引的构建
         * @throws Exception Lucene 异常
         */
        public void updateReconstructorIndex()throws Exception;
}
