package com.coding.mapper;

import com.coding.pojo.ItemIndex;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemIndexMapper {


    /**
     * 根据商品索引唯一ID删除商品索引信息
     * @param indexId 商品索引唯一ID
     * @return 是否删除成功 非0 ：成功   0:失败
     */
    public int deleteItemIndexByPrimaryKey(Integer indexId)throws Exception;

    /**
     * 根据商品索引唯一ID组批量删除商品索引信息
     * @parm indexIdArray 商品索引唯一ID组
     * @return 是否删除成功 非0 ：成功   0:失败
     */
    public int deleteItemIndexByPrimaryKeyArray(@Param("indexIdArray") Integer[] indexIdArray)throws Exception;

    public int deleteItemIndexAll()throws Exception;

    /**
     * 按需插入商品索引信息
     * @param itemIndex 封装了商品索引信息的 ItemIndex 类对象
     * @return 是否插入成功 非0:成功  0:失败
     */
    public int insertItemIndexSelective(ItemIndex itemIndex)throws Exception;

    /**
     * 根据商品索引唯一ID查询商品索引信息
     * @param indexId 商品索引唯一ID
     * @return 满足查询条件的封装了商品索引信息的 itemIndex 类对象
     */
    public ItemIndex selectItemIndexByPrimaryKey(Integer indexId)throws Exception;

//    /**
//     * 查询功能模块
//     * @param pagingCustomItemIndex 封装了基本查询信息的 Paging 类的扩展类 PagingCustomItemIndex 类对象
//     * @return 满足查询条件的 ItemIndex 类对象
//     * @throws Exception
//     */
//    public List<ItemIndex> selectItemIndex(PagingCustomItemIndex pagingCustomItemIndex)throws Exception;

    public List<ItemIndex> selectItemIndexAll()throws Exception;

    /**
     * 根据商品索引唯一ID按需更新商品索引信息
     * @param itemIndex 封装了商品索引信息的 ItemIndex 类对象
     * @return 是否更新成功 非0:成功   0:失败
     */
    public int updateItemIndexByPrimaryKeySelective(ItemIndex itemIndex)throws Exception;


}