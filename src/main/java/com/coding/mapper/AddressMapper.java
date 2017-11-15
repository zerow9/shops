package com.coding.mapper;

import com.coding.paging.PagingCustomAddress;
import com.coding.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    /**
     * 根据 addressId 删除地址信息
     * @param addressId 地址唯一ID
     */
    public int deleteAddressByPrimaryKey(Integer addressId) throws Exception ;

    /**
     * 插入一条地址信息
     * @param address 封装了诋毁子信息的 Address 对象
     */
    public int insertAddress(Address address)  throws Exception;

    /**
     * 根据地址唯一id查询地址信息
     * @param addressId 地址唯一ID
     * @return 地址信息
     */
    public Address selectAddressByPrimaryKey(@Param("addressId") Integer addressId) throws Exception;

    /**
     * 根据地址唯一id更新地址信息
     * @param address  封装了地址信息的 Address 对象
     */
    public int updateAddressByPrimaryKey(Address address) throws Exception;

    /**
     * 修改用户默认地址（将需修改用户Uuid、待修改为默认地址的AddressID封装）
     * @param address 封装了地址信息 Address 类对象
     * @return 是否更新成功  非0: 成功  0:失败
     * @throws Exception
     */
    public int updateAddressUserDefaultAddress(Address address)throws Exception;

    /**
     * 返回所有地址信息
     * @return 返回封装了地址信息的 Address 对象集合
     */
    public List<Address> selectAddressAll() throws Exception;

    /**
     *
     * @param user_uuid 用户唯一ID
     * @return  封装了地址信息的 Address 类的对象集合
     */
    public List<Address> selectAddressByUserID(@Param("user_uuid") String user_uuid) throws Exception;

    /**
     * 返回地址表中一共有多少条数据
     * @return 封装了地址信息的 Address 类对象
     * @throws Exception
     */
    public Integer selectAddressCount()throws Exception;
}