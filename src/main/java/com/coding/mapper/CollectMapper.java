package com.coding.mapper;

import com.coding.paging.PagingCustomCollect;
import com.coding.pojo.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectMapper {

    /**
     * 根据收藏唯一ID删除收藏信息
     * @param collectId 收藏唯一ID
     * @return 是否删除成功 0:失败 非0:成功
     * @throws Exception
     */
    public int deleteCollectByPrimaryKey(Integer collectId)throws Exception;

    /**
     * 根据收藏唯一ID组批量删除收藏信息
     * @param collectIdArray 收藏唯一ID组
     * @return 是否删除成功 0:失败 非0:成功
     * @throws Exception
     */
    public int deleteCollectByPrimaryKeyArray(@Param("collectIdArray") Integer[] collectIdArray) throws Exception;

    /**
     * 插入收藏信息
     * @param collect 封装了收藏信息的 Collect 类对象
     * @return 是否插入成功 0:失败 非0:成功
     * @throws Exception
     */
    public int insertCollect(Collect collect)throws Exception;

    /**
     * 按需插入收藏信息
     * @param collect 封装了收藏信息的 Collect 类对象
     * @return 是否插入成功 0:失败 非0:成功
     * @throws Exception
     */
    public int insertCollectSelective(Collect collect)throws Exception;

    /**
     * 根据收藏表唯一ID查询收藏信息
     * @param collectId 收藏表唯一ID
     * @return 满足查询条件的封装了收藏表信息的 Collect 类对象
     * @throws Exception
     */
    public Collect selectCollectByPrimaryKey(Integer collectId)throws Exception;

    /**
     * 查询收藏表中总的数据量
     * @return 收藏表中一共有多少条数据
     * @throws Exception
     */
    public Integer selectCollectCount()throws Exception;

    /**
     * 收藏表查询功能模块
     * @param pagingCustomCollect 基础查询类 Paging 的扩展类，封装了查询所需的所有条件
     * @return 满足查询条件的封装了收藏基本信息的 Collect 类对象集合
     * @throws Exception
     */
    public List<Collect> selectCollect(PagingCustomCollect pagingCustomCollect)throws Exception;

    /**
     * 根据收藏表唯一ID按需更新收藏表信息
     * @param collect 封装了需更新的收藏表基本信息 Collect 类对象
     * @return 是否更新成功 0:失败 非0:成功
     * @throws Exception
     */
    public int updateCollectByPrimaryKeySelective(Collect collect)throws Exception;

    /**
     * 根据收藏表唯一ID更新收藏表信息
     * @param collect 封装了需更新的收藏表基本信息 Collect 类对象
     * @return 是否更新成功 0:失败 非0:成功
     * @throws Exception
     */
    public int updateCollectByPrimaryKey(Collect collect)throws Exception;
}