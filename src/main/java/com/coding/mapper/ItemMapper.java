package com.coding.mapper;

import com.coding.pojo.Item;
import com.coding.paging.PagingCustomItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {

    /**
     * 根据商品ID删除商品信息
     *
     * @param itemId 商品唯一ID
     */
    public int deleteItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 根据商品ID批量删除商品信息
     *
     * @param itemIdArray 商品唯一ID数组
     */
    public int deleteItemByItemIdArray(@Param("itemIdArray") Integer[] itemIdArray) throws Exception;

    /**
     * 增加商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public int insertItem(Item item) throws Exception;

    /**
     * 根据商品唯一ID查询商品信息
     *
     * @param itemId 商品唯一ID
     * @return 封装了商品信息的 Item 类对象
     */
    public Item selectItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 查询所有商品信息
     *
     * @return 封装了商品信息的 Item 类对象
     */
    public List<Item> selectItemAll() throws Exception;


    /**
     * 根据商品唯一ID更新商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public int updateItemByPrimaryKey(Item item) throws Exception;

    /**
     * 根据商品名称模糊查找商品信息
     *
     * @param  fuzzyItemName 商品名称
     * @return 通过正则表达式满足模糊匹配的商品信息
     */
    public List<Item> selectItemFuzzyByItemName(@Param("fuzzyItemName") String fuzzyItemName)throws Exception;

    /**
     * 根据商品类别查找商品信息
     * @param itemTypeId 商品类别ID
     * @return 满足查询条件的 Item 类对象集合
     * @throws Exception
     */
    public List<Item> selectItemByItemType(@Param("itemTypeId") Integer itemTypeId)throws Exception;

    /**
     * 根据参数条件商品信息，并按要求进行排序（参数控制）
     * @param fuzzyItemName 模糊查询的商品名称
     * @param sortRule  排序规则  desc：降序 asc：升序
     * @param sortColumn 需要按照什么字段进行排序（数据库中字段名字）
     * @return 封装了商品属性的 Item 类对象集合（进行了排序）
     * @throws Exception
     */
    public List<Item> selectItemFuzzyByItemNameSort(@Param("fuzzyItemName") String fuzzyItemName,@Param("sortRule")String sortRule,@Param("sortColumn")String sortColumn)throws Exception;

    /**
     * 这是一个查询功能模块的集合，包含了众多的查询功能，根据 Paging 对象的封装
     * 需要用到什么参数就将参数封装到 Paging 中，不需要用到的参数切忌不要封装。
     * 该接口通过 Paging 中参数的封装去进行 SQL 语句拼接，参数的封装需要小心。
     * @param paging 包含了所有查询条件的 Paging 类对象
     * @return 封装了商品信息的 Item 类对象集合
     * @throws Exception
     */
    public List<Item> selectItem(PagingCustomItem paging)throws Exception;

    /**
     * 返回商品表中一共有多少条数据
     * @return 封装了商品信息的 Item 类对象
     * @throws Exception
     */
    public Integer selectItemCount()throws Exception;

}