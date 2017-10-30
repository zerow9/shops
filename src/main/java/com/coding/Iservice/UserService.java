package com.coding.Iservice;


import com.coding.pojo.Address;
import com.coding.pojo.User;

import java.util.List;

public interface UserService {
    /*------------------------------------------用户表------------------------------------------------------------------*/
    /**
     * 插入一条用户信息、用户注册
     * @param user
     */
    public void insertUser(User user);

    /**
     * 通过用户唯一 ID 查询用户信息、用户登录、用户验证
     * @param userUuid
     * @return
     */
    public User selectUserByPrimaryKey(String userUuid);

    /**
     * 根据用户唯一 ID 更新用户信息、修改个人信息
     * @param user
     */
    public void  updateUserByPrimaryKey(User user);
    /*------------------------------------------收获地址表------------------------------------------------------------------*/
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
     * @param addressId
     */
    public void updateAddressByPrimaryKey(Address address);

    /**
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAddressAll();
}
