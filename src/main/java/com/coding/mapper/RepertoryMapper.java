package com.coding.mapper;

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
    public void deleteRepertoryByPrimaryKey(Integer repertoryId) throws Exception;

    /**
     * @param repertory 封装了库存信息的 Repertory 类对象
     * @throws Exception
     */
    public void insertRepertory(Repertory repertory) throws Exception;

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
    public void updateRepertoryByPrimaryKey(Repertory repertory) throws Exception;

    /**
     * @return 装了库存信息的 Repertory 类对象集合
     * @throws Exception
     */
    public List<Repertory> selectRepertoryAll() throws Exception;
}