package com.coding.Iservice;

import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;

import java.util.List;

public interface IAdminServiceI extends IUserService {
    /*------------------------------------------用户表------------------------------------------------------------------*/
    /**
     * 根据用户 ID 删除用户信息
     * @param userUuid
     */
    public void deleteUserByPrimaryKey(String userUuid) throws Exception;

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> selectUserAll() throws Exception;
/*------------------------------------------分组表------------------------------------------------------------------*/
    /**
     * 通过分组 ID 删除分组信息
     * @param groupId 分组唯一ID
     */
    public void deleteGroupsByPrimaryKey(Integer groupId) throws Exception;

    /**
     * 插入分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void insertGroups(Groups groups) throws Exception;

    /**
     * 根据分组 ID 查询分组信息
     * @param groupId 分组唯一ID
     * @return  封装了分组信息的 Groups 对象
     */
    public Groups selectGroupsByPrimaryKey(Integer groupId) throws Exception;

    /**
     * 根据分组 ID 更新分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception;

    /**
     * 查询所有分组信息
     * @return 封装了分组信息的 Groups 对象 集合
     */
    public List<Groups> selectGroupsAll() throws Exception;

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    /**
     * 根据 用户唯一id删除用户信息
     * @param adminId
     */
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception;

    /**
     * 插入管理员信息
     * @param admin
     */
    public void  insertAdmin(Admin admin) throws Exception;

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId
     * @return
     */
    public Admin selectAdminByPrimaryKey(Integer adminId) throws Exception;

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin
     */
    public void updateAdminByPrimaryKey(Admin admin) throws Exception;

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Admin> selectAdminAll() throws Exception;

}
