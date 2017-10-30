package com.coding.serviceImpl;

import com.coding.Iservice.UserService;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Address;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Transactional
    public void insertUser(User user) {
        String id= UUID.randomUUID().toString().replace("-", "_");
        user.setUserUuid(id);
        userMapper.insertUser(user);
    }

    public User selectUserByPrimaryKey(String userUuid) {
        if (userUuid!=""&&userUuid!=null){
            User user = userMapper.selectUserByPrimaryKey(userUuid);
            return  user;
        }
        return null;
    }

    @Transactional
    public void updateUserByPrimaryKey(User user) {
        userMapper.updateUserByPrimaryKey(user);
    }

    @Transactional
    public void deleteAddressByPrimaryKey(Integer addressId) {
        if (addressId!=0&&addressId!=null){
            addressMapper.deleteAddressByPrimaryKey(addressId);
        }
    }

    @Transactional
    public void insertAddress(Address address) {
            addressMapper.insertAddress(address);
    }

    public Address selectAddressByPrimaryKey(Integer addressId) {
        if (addressId!=0&&addressId!=null){
          Address address =  addressMapper.selectAddressByPrimaryKey(addressId);
          return  address;
        }
        return null;
    }

    @Transactional
    public void updateAddressByPrimaryKey(Address address) {
            addressMapper.updateAddressByPrimaryKey(address);
    }

    public List<Address> selectAddressAll() {
        List<Address> addresses = addressMapper.selectAddressAll();
        return addresses;
    }
}
