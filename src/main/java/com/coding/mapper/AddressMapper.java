package com.coding.mapper;

import com.coding.pojo.Address;
import java.util.List;

public interface AddressMapper {

    /**
     * 根据 addressId 删除地址信息
     * @param addressId 地址唯一ID
     */
    public void deleteAddressByPrimaryKey(Integer addressId) ;

    /**
     * 插入一条地址信息
     * @param address 封装了诋毁子信息的 Address 对象
     */
    public void insertAddress(Address address);

    /**
     * 根据地址唯一id查询地址信息
     * @param addressId 地址唯一ID
     * @return 地址信息
     */
    public Address selectAddressByPrimaryKey(Integer addressId);

    /**
     * 根据地址唯一id更新地址信息
     * @param address  封装了地址信息的 Address 对象
     */
    public void updateAddressByPrimaryKey(Address address);

    /**
     * 返回所有地址信息
     * @return 返回封装了地址信息的 Address 对象集合
     */
    public List<Address> selectAddressAll();

    public List<Address> selectAddressByUserID(String uuid);
}