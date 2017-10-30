package com.coding.mapper;

import com.coding.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    /**
     * 根据 用户唯一id删除用户信息
     * @param adminId 管理员唯一ID
     */
    public void deleteAdminByPrimaryKey(Integer adminId);

    /**
     * 插入管理员信息
     * @param admin 封装了管理员信息的 Admin 对象
     */
    public void  insertAdmin(Admin admin);

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId   管理员唯一ID
     * @return
     */
    public Admin selectAdminByPrimaryKey(Integer adminId);

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin 封装了管理员信息的 Admin 对象
     * @param adminId   管理员唯一ID
     */
    public void updateAdminByPrimaryKey(Admin admin);

    /**
     * 查询所有管理员信息
     * @return  返回封装了管理员信息的 Admin 对象集合
     */
    public List<Admin> selectAdminAll();
}