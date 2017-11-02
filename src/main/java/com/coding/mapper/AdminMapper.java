package com.coding.mapper;

import com.coding.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    /**
     * 根据 用户唯一id删除用户信息
     *
     * @param adminId 管理员唯一ID
     */
    public int deleteAdminByPrimaryKey(Integer adminId) throws Exception;

    /**
     * 插入管理员信息
     *
     * @param admin 封装了管理员信息的 Admin 对象
     */
    public int insertAdmin(Admin admin) throws Exception;

    /**
     * 通过管理员唯一 ID 查询管理员信息
     *
     * @param adminId 管理员唯一ID
     * @return 封装了管理员信息的 Admin 类对象
     */
    public Admin selectAdminByPrimaryKey(@Param("adminId") Integer adminId) throws Exception;

    /**
     * 通过管理员唯一 ID 修改管理员信息
     *
     * @param admin 封装了管理员信息的 Admin 对象
     */
    public int updateAdminByPrimaryKey(Admin admin) throws Exception;

    /**
     * 查询所有管理员信息
     *
     * @return 返回封装了管理员信息的 Admin 对象集合
     */
    public List<Admin> selectAdminAll() throws Exception;

    /**
     * 批量删除管理员信息
     *
     * @param adminIdArray 管理员ID数组
     * @return 0:删除失败 1:删除成功
     * @throws Exception
     */
    public int deleteAdminByAdminIdArray(@Param("adminIdArray") Integer[] adminIdArray) throws Exception;

    /**
     * 通过分页查询所有管理员信息
     *
     * @param nowPage 当前页面
     * @param number  每页需要查询的用户数量
     * @return 封装了管理员信息的 Admin 类对象
     * @throws Exception
     */
    public List<Admin> selectAdminAllPaging(@Param("nowPage") Integer nowPage, @Param("number") Integer number) throws Exception;

}