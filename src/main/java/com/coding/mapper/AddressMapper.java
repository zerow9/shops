package com.coding.mapper;

import com.coding.pojo.Address;
import java.util.List;

public interface AddressMapper {
    /**
     * 根据 addressId 删除地址信息
     * @param addressId
     */
    public void deleteByPrimaryKey(Integer addressId);

    /**
     * 插入一条地址信息
     * @param address
     */
    public void insert(Address address);

    /**
     * 根据地址唯一id查询地址信息
     * @param addressId
     * @return 地址信息
     */
    public Address selectByPrimaryKey(Integer addressId);

    /**
     * 根据地址唯一id更新地址信息
     * @param address
     * @param addressId
     */
    public void updateByPrimaryKey(Address address, Integer addressId);

    /**
     * 返回所有地址信息
     * @return
     */
    public List<Address> selectAll();

}