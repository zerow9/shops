package com.coding.mapper;

import com.coding.pojo.Vender;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenderMapper {
    /**
     * 根据厂家ID删除厂家信息
     *
     * @param venderId 厂家ID
     * @throws Exception
     */
    public void deleteVenderByPrimaryKey(Integer venderId) throws Exception;

    /**
     * 增加厂家信息
     *
     * @param vender 封装了厂家信息的 Vender 类对象
     * @throws Exception
     */
    public void insertVender(Vender vender) throws Exception;

    /**
     * 根据厂家唯一ID 查询厂家信息
     *
     * @param venderId 厂家ID
     * @return 封装类厂家信息的 Vender 对象
     * @throws Exception
     */
    public Vender selectVenderByPrimaryKey(@Param("venderId") Integer venderId) throws Exception;

    /**
     * 根据厂家ID更新厂家信息
     *
     * @param vender 封装了厂家信息的 Vender 对象
     * @throws Exception
     */
    public void updateVenderByPrimaryKey(Vender vender) throws Exception;

    /**
     * 查询所有厂家信息
     *
     * @return 封装了厂家信息的 Vender 对象集合
     * @throws Exception
     */
    public List<Vender> selectVenderAll() throws Exception;

}