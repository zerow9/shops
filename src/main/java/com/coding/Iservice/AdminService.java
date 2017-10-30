package com.coding.Iservice;

import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;

import java.util.List;

public interface AdminService {
    /*------------------------------------------用户表------------------------------------------------------------------*/
    /**
     * 根据用户 ID 删除用户信息
     * @param userUuid
     */
    public void deleteUserByPrimaryKey(String userUuid);

    /**
     * 插入一条用户信息
     * @param user
     */
    public void insertUser(User user);

    /**
     * 通过用户唯一 ID 查询用户信息
     * @param userUuid
     * @return
     */
    public User selectUserByPrimaryKey(String userUuid);

    /**
     * 根据用户唯一 ID 更新用户信息
     * @param user
     */
    public void  updateUserByPrimaryKey(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> selectUserAll();
/*------------------------------------------分组表------------------------------------------------------------------*/
    /**
     * 通过分组 ID 删除分组信息
     * @param groupId 分组唯一ID
     */
    public void deleteGroupsByPrimaryKey(Integer groupId);

    /**
     * 插入分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void insertGroups(Groups groups);

    /**
     * 根据分组 ID 查询分组信息
     * @param groupId 分组唯一ID
     * @return  封装了分组信息的 Groups 对象
     */
    public Groups selectGroupsByPrimaryKey(Integer groupId);

    /**
     * 根据分组 ID 更新分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public void updateGroupsByPrimaryKey(Groups groups);

    /**
     * 查询所有分组信息
     * @return 封装了分组信息的 Groups 对象 集合
     */
    public List<Groups> selectGroupsAll();

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    /**
     * 根据 用户唯一id删除用户信息
     * @param adminId
     */
    public void deleteAdminByPrimaryKey(Integer adminId);

    /**
     * 插入管理员信息
     * @param admin
     */
    public void  insertAdmin(Admin admin);

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId
     * @return
     */
    public Admin selectAdminByPrimaryKey(Integer adminId);

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin
     */
    public void updateAdminByPrimaryKey(Admin admin);

    /**
     * 查询所有管理员信息
     * @return
     */
    public List<Admin> selectAdminAll();
    /*------------------------------------------收获地址表表------------------------------------------------------------------*/
    /**
     * 根据 addressId 删除地址信息
     * @param addressId
     */
    public void deleteAddressByPrimaryKey(Integer addressId);

    /**
     * 插入一条地址信息
     * @param address
     */
    public void insertAddress(Address address);

    /**
     * 根据地址唯一id查询地址信息
     * @param addressId
     * @return 地址信息
     */
    public Address selectAddressByPrimaryKey(Integer addressId);

    /**
     * 根据地址唯一id更新地址信息
     * @param address
     */
    public void updateAddressByPrimaryKey(Address address);

    /**
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAddressAll();
}
