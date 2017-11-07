package com.coding.Iservice;


import com.coding.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    /*------------------------------------------用户表------------------------------------------------------------------*/
    /**
     * 插入一条用户信息、用户注册
     * @param user
     */
    public void insertUser(User user) throws Exception;

    /**
     * 通过用户唯一 ID 查询用户信息、用户登录、用户验证
     * @param userUuid
     * @return
     */
    public User selectUserByPrimaryKey(String userUuid) throws  Exception;

    /**
     * 根据用户唯一 ID 更新用户信息、修改个人信息
     * @param user
     */
    public void  updateUserByPrimaryKey(User user) throws Exception;

    /**
     * 查询用户表中一共有多少数据
     * @return 封装了用户信息的 User 类对象集合
     * @throws Exception
     */
    public Integer selectUserCount()throws Exception;

    /**
     * 根据帐号（电话）去查找密码
     * @param userPhone 用户帐号
     * @return 如果数据库中有该帐号信息，那么就返回该用户密码(设计不规范，导致账户可能会重复，返回密码列表，去密码列表中匹配)
     * @throws Exception
     */
    public List<String> selectUserPassword(String userPhone)throws Exception;
    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    /**
     * 根据 addressId 删除地址信息
     * @param addressId
     */
    public void deleteAddressByPrimaryKey(Integer addressId) throws Exception;

    /**
     * 插入一条地址信息
     * @param address
     */
    public void insertAddress(Address address) throws Exception;

    /**
     * 根据地址唯一id查询地址信息
     * @param addressId
     * @return 地址信息
     */
    public Address selectAddressByPrimaryKey(Integer addressId) throws Exception;

    /**
     * 根据地址唯一id更新地址信息
     * @param address
     * @param address
     */
    public void updateAddressByPrimaryKey(Address address) throws Exception;

    /**
     * 根据用户uuid查询收获地址
     * @throws Exception
     */
    public List<Address> selectAddressByUserID(String userUuid) throws  Exception;
     /*------------------------------------------用户投诉表------------------------------------------------------------------*/
    /**
     * 根据投诉ID删除投诉信息
     * @param complaintId 投诉表唯一ID
     * @return 是否删除成功 非0:成功 0:不成功
     * @throws Exception
     */
    public void deleteComplaintByPrimaryKey(Integer complaintId)throws Exception;

    /**
     * 按需插入投诉信息
     * @param complaint 封装了投诉信息的 Complaint 类对象
     * @return 是否插入成功 非0:成功 0:失败
     * @throws Exception
     */
    public void insertComplaintSelective(Complaint complaint)throws Exception;

    /**
     * 根据投诉表ID按需更新投诉表信息
     * @param record 封装了投诉信息的 Complaint 类对象
     * @return 是否更新成功 非0:成功 0:失败
     * @throws Exception
     */
    public void updateComplaintByPrimaryKeySelective(Complaint record)throws Exception;

    /**
     * 根据投诉ID查询用户投诉信息
     * @param complaintId
     * @return
     * @throws Exception
     */
    public Complaint selectComplaintByPrimaryKey(Integer complaintId) throws Exception;
    /**
     * 投诉表查询功能大集合（如需查询单个用户所有投诉信息，只需要封装pagingCustomComplaint对象中的complaint对象的accuserId属性）
     * PagingCustomComplaint中的时间字段是 String 类型 ，格式要和数据库 dateTime 一样  yyyy-MM-dd HH:mm:ss
     * 实现：主键，被投诉人，投诉人，处理状态，投诉时间范围，排序规则，分页
     * @param pagingCustomComplaint 封装了投诉信息的 Complaint 类对象
     * @return 满足查询条件的封装了投诉信息的 Complaint 类对象集合
     * @throws Exception
     */
    public List<Complaint> selectComplaint(PagingCustomComplaint pagingCustomComplaint)throws Exception;
     /*------------------------------------------商品类别表------------------------------------------------------------------*/

    /**
     * 根据商品ID查询商品类别信息
      * @param itemTypeId
     * @return ItemType
     * @throws Exception
     */
    public ItemType selectItemTypeByPrimaryKey(Integer itemTypeId) throws Exception;

    /**
     * 查询所有商品类别信息
     * @return  List<ItemType>
     * @throws Exception
     */
    public List<ItemType> selectItemTypeAll()throws Exception;

    /**
     * 返回商品类别表中一共有多少条数据
     * @return 封装了商品类别信息的 ItemType 类对象
     * @throws Exception
     */
    public Integer selectItemTypeCount()throws Exception;

 /*------------------------------------------商品表------------------------------------------------------------------*/
    /**
     * 根据商品唯一ID查询商品信息
     *
     * @param itemId 商品唯一ID
     * @return 封装了商品信息的 Item 类对象
     */
    public Item selectItemByPrimaryKey(Integer itemId) throws Exception;

    /**
     * 查询所有商品信息
     *
     * @return 封装了商品信息的 Item 类对象
     */
    public List<Item> selectItemAll() throws Exception;

    /**
     * 根据商品名称模糊查找商品信息
     *
     * @param  fuzzyItemName 商品名称
     * @return 通过正则表达式满足模糊匹配的商品信息
     */
    public List<Item> selectItemFuzzyByItemName(String fuzzyItemName)throws Exception;

    /**
     * 根据商品类别查找商品信息
     * @param itemTypeId 商品类别ID
     * @return 满足查询条件的 Item 类对象集合
     * @throws Exception
     */
    public List<Item> selectItemByItemType(Integer itemTypeId)throws Exception;
    /**
     * 根据参数条件商品信息，并按要求进行排序（参数控制）
     * @param fuzzyItemName 模糊查询的商品名称
     * @param sortRule  排序规则  desc：降序 asc：升序
     * @param sortColumn 需要按照什么字段进行排序（数据库中字段名字）
     * @return 封装了商品属性的 Item 类对象集合（进行了排序）
     * @throws Exception
     */
    public List<Item> selectItemFuzzyByItemNameSort(String fuzzyItemName,String sortRule,String sortColumn)throws Exception;

    /**
     * 这是一个查询功能模块的集合，包含了众多的查询功能，根据 Paging 对象的封装
     * 需要用到什么参数就将参数封装到 Paging 中，不需要用到的参数切忌不要封装。
     * 该接口通过 Paging 中参数的封装去进行 SQL 语句拼接，参数的封装需要小心。
     * 名字（模糊）
     * @param paging 包含了所有查询条件的 Paging 类对象
     * @return 封装了商品信息的 Item 类对象集合
     * @throws Exception
     */
    public List<Item> selectItem(PagingCustomItem paging)throws Exception;

    /**
     * 返回商品表中一共有多少条数据
     * @return 封装了商品信息的 Item 类对象
     * @throws Exception
     */
    public Integer selectItemCount()throws Exception;

}
