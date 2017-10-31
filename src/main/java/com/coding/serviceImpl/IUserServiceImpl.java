package com.coding.serviceImpl;

import com.coding.Iservice.IUserService;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    /*----------------------------------------用户表------------------------------------------------------------------*/

    @Transactional
    public void insertUser(User user)  throws Exception{
        userMapper.insertUser(user);
    }

    public User selectUserByPrimaryKey(String userUuid) throws  Exception{
        if (userUuid.equals("") && userUuid.equals(null)) {
            User user= userMapper.selectUserByPrimaryKey(userUuid);
            if(user==null)
                throw  new Exception("查询为空");
            return user;
        }
        return null;
    }

    @Transactional
    public void updateUserByPrimaryKey(User user) throws Exception{
        userMapper.updateUserByPrimaryKey(user);
    }

    /*------------------------------------------收获地址表表------------------------------------------------------------------*/
    @Transactional
    public void deleteAddressByPrimaryKey(Integer addressId) throws Exception{
        if (addressId != 0) {
            addressMapper.deleteAddressByPrimaryKey(addressId);
        }
        else {
            throw  new Exception("查询不到收获地址");
        }
    }

    @Transactional
    public void insertAddress(Address address) throws Exception{
        addressMapper.insertAddress(address);
    }

    public Address selectAddressByPrimaryKey(Integer addressId) throws Exception {
        if (addressId != 0) {
            return addressMapper.selectAddressByPrimaryKey(addressId);
        }
        if(addressId==0) { throw  new Exception("查询不到收获地址");}
        return null;
    }

    @Transactional
    public void updateAddressByPrimaryKey(Address address) throws Exception {
        addressMapper.updateAddressByPrimaryKey(address);
    }

    public List<Address> selectAddressAll() throws Exception {
        return addressMapper.selectAddressAll();
    }

    public List<Address> selectAddressByUserID(String userUuid) throws Exception {
        if (userUuid.equals("") && userUuid.equals(null)) {
            List<Address> addresses = addressMapper.selectAddressByUserID(userUuid);
            if(addresses==null)
                throw  new Exception("该用户没有收获地址信息");
            return addresses;
        }
        return null;

    }
}
