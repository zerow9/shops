package com.coding.mapper;

import com.coding.paging.PagingCustomRepertory;
import com.coding.pojo.Repertory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepertoryMapper {
    /**
     * 根据库存ID删除库存信息
     *
     * @param repertoryId 库存ID
     * @throws Exception
     */
    public int deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception;

    /**
     * 批量删除库存信息
     * @param repertoryIdArrary
     * @return
     */
    public int deleteRepertoryByPrimaryKeyArray(@Param("repertoryIdArrary") Integer[] repertoryIdArrary)throws Exception;

    /**
     * @param repertory 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public int insertRepertory(Repertory repertory) throws Exception;

    /**
     * @param repertoryId 库存ID
     * @return 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public Repertory selectRepertoryByPrimaryKey(@Param("repertoryId") Integer repertoryId) throws Exception;

    /**
     * @param repertory 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public int updateRepertoryByPrimaryKey(Repertory repertory) throws Exception;

    /**
     * @return 装了库存信息的 Repertory 类对象集合
     * @throws Exception
     */
    public List<Repertory> selectRepertoryAll() throws Exception;

    /**
     * 库存信息表的综合查询
     * @return
     * @throws Exception
     */
    public List<Repertory> selectRepertory(PagingCustomRepertory pagingCustomRepertory) throws Exception;

    /**
     * 返回库存表中一共有多少条数据
     * @return 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public Integer selectRepertoryCount()throws Exception;
}