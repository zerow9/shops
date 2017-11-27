package com.coding.Iservice;


import com.coding.Lucene.SearchField;
import com.coding.pojo.Item;

import java.util.List;

public interface IindexItemService {

        /**
         * 添加索引
         * @param fields Item对象
         * @param inDatabase 是否进行索引数据库备份
         * @throws Exception index异常，sql异常
         */
        public void addIndex(Item fields, boolean inDatabase)throws Exception;

        /**
         * 删除索引
         * @param id Itemid
         * @param inDatabase 是否进行索引数据库备份
         * @throws Exception index异常，sql异常
         */
        public void deleteIndex(Integer id, boolean inDatabase)throws Exception;

        /**
         * 修改索引
         * @param fields Item对象
         * @param inDatabase 是否进行索引数据库备份
         * @throws Exception index异常，sql异常
         */
        public void updateIndex(Item fields, boolean inDatabase)throws Exception;


        /**
         * 根据自定义搜索对象搜索索引
         * @param field 自定义搜索对象
         * @return 商品列表
         * @throws Exception index异常
         */
        public List<Item> findByIndex(SearchField field)throws Exception;

        /**
         * 根据索引主键查询索引，获取索引全部信息
         * @param itemId 商品主键ID
         * @return 商品对象
         * @throws Exception index异常
         */
        public Item findIndexById (Integer itemId)throws Exception;

        /**
         * 查询全部索引
         * @param field 自定义搜索类，用于分页
         * @return 商品列表
         * @throws Exception index异常
         */
        public List<Item> findIndexAll(SearchField field)throws Exception;

        /**
         * 根据自定义搜索对象获取商品列表的数量,便于分页
         * @param field 自定义搜索对象
         * @return 搜索结果的数量
         * @throws Exception index异常
         */
        public Integer getDocCount(SearchField field)throws Exception;

        /**
         * 提交索引,仅仅是从内存中提交
         */
        public void updateCommitIndex()throws Exception;

        /**
         * 重构索引
         */
        public void updateReconstructorIndex()throws Exception;

        /**
         *删除全部索引
         */
        public void deleteIndexAll()throws Exception;

        /**
         * 设置索引，将数据库中没有添加为索引的对象完全添加
         */
        public void updateSetIndex()throws Exception;
}
