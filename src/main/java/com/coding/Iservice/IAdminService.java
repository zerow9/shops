package com.coding.Iservice;

import com.coding.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminService extends IUserService {
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
/*------------------------------------------收获地址表表------------------------------------------------------------------*/
    /**
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAddressAll() throws Exception;
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

     /*------------------------------------------商品类别表------------------------------------------------------------------*/

    /**
     * 根据商品类别ID删除商品
     * @param itemTypeId
     * @throws Exception
     */
    public void deleteItemTypeByPrimaryKey(Integer itemTypeId)throws Exception;

    /**
     * 插入新商品类别
     * @param itemType
     * @throws Exception
     */
    public void  insertItemType(ItemType itemType)throws Exception;

    /**
     * 根据商品类别ID修改商品类别信息
     * @param itemType
     * @throws Exception
     */
    public void updateItemTypeByPrimaryKey(ItemType itemType)throws Exception;

 /*------------------------------------------商品表------------------------------------------------------------------*/
    /**
     * 根据商品ID删除商品信息
     *
     * @param itemId 商品唯一ID
     */
    public void deleteItemByPrimaryKey(@Param("itemId") Integer itemId) throws Exception;

    /**
     * 增加商品信息
     *
     * @param item 封装了商品信息的 Item 类对象
     */
    public void insertItem(Item item) throws Exception;

    /**
     * 根据商品唯一ID更新商品信息
     *
     * @param item 商品ID
     */
    public void updateItemByPrimaryKey(Item item) throws Exception;
 /*------------------------------------------库存表------------------------------------------------------------------*/
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

    /*------------------------------------------厂家信息表------------------------------------------------------------------*/
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
