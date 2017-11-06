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
     * @param nowPage 当前页
     * @param number  每页需要查询的用户数量
     * @return 封装了管理员信息的 Admin 类对象
     * @throws Exception
     */
    public List<Admin> selectAdminAllPaging(@Param("nowPage") Integer nowPage, @Param("number") Integer number) throws Exception;

    /**
     * 返回管理员表中一共有多少条数据
     * @return 封装了管理员信息的 Groups 类对象
     * @throws Exception
     */
    public Integer selectAdminCount()throws Exception;

    /**
     * 根据帐号去查找密码
     * @param adminAccount Admin 帐号
     * @return 如果数据库中有该帐号信息，那么就返回该用户密码(设计不规范，导致账户可能会重复，返回密码列表，去密码列表中匹配)
     * @throws Exception
     */
    public List<String> selectAdminPassword(@Param("adminAccount") String adminAccount)throws Exception;

    /**
     * 根据帐号密码查询用户信息
     * @param adminAccount Admin 帐号
     * @param adminPassword Admin 密码
     * @return 如果数据库中存在和传入帐号密码匹配的管理员信息，那么就返回该管理员信息
     * @throws Exception
     */
    public Admin selectAdminAccountAndPassword(@Param("adminAccount") String adminAccount,@Param("adminPassword") String adminPassword)throws Exception;
}