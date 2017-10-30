package com.coding.mapper;

import com.coding.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    /**
     * 根据 用户唯一id删除用户信息
     * @param adminId
     */
    public void deleteByPrimaryKey(Integer adminId);

    /**
     * 插入管理员信息
     * @param admin
     */
    public void  insert(Admin admin);

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId
     * @return
     */
    public Admin selectByPrimaryKey(Integer adminId);

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin
     * @param adminId
     */
    public void updateByPrimaryKey(Admin admin, Integer adminId);

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Admin> selectAll();
}