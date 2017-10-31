package com.coding.Iservice;


import com.coding.pojo.Address;
import com.coding.pojo.User;

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
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAddressAll() throws Exception;

    /**
     * 根据用户uuid查询收获地址
     * @throws Exception
     */
    public List<Address> selectAddressByUserID(String userUuid) throws  Exception;
}
