package com.coding.serviceImpl;

import com.coding.Iservice.IUserService;
import com.coding.comomInterface.ErrorExc;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.ItemTypeMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Address;
import com.coding.pojo.ItemType;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ErrorExc implements IUserService {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ItemTypeMapper itemTypeMapper;

    /*----------------------------------------用户表------------------------------------------------------------------*/

    @Transactional
    public void insertUser(User user)  throws Exception{
        try{
        userMapper.insertUser(user);
        } catch (Exception e){
            throw  new Exception("插入用戶信息时出錯");
        }

    }

    public User selectUserByPrimaryKey(String userUuid) throws  Exception{
        if (!userUuid.equals("") && !userUuid.equals(null)) {
            User user= userMapper.selectUserByPrimaryKey(userUuid);
             except(user,"用户查询为空");
            return user;
        }
        return null;
    }

    @Transactional
    public void updateUserByPrimaryKey(User user) throws Exception{
        try {
            userMapper.updateUserByPrimaryKey(user);
        }catch (Exception e){
            throw new Exception("修改用户信息时出错");
        }

    }

    /*------------------------------------------收获地址表表------------------------------------------------------------------*/
    @Transactional
    public void deleteAddressByPrimaryKey(Integer addressId) throws Exception{
        if (addressId != 0) {
            try {
                addressMapper.deleteAddressByPrimaryKey(addressId);
            }catch (Exception e){
                throw new Exception("删除收获地址时出错");
            }
        }
    }

    @Transactional
    public void insertAddress(Address address) throws Exception{
        try {
            addressMapper.insertAddress(address);
        }catch (Exception e){
            throw new Exception("插入收获地址时出错");
        }
    }

    public Address selectAddressByPrimaryKey(Integer addressId) throws Exception {
        if (addressId != 0) {
            Address address = addressMapper.selectAddressByPrimaryKey(addressId);
            except(address,"收货地址查询为空");
            return address;
        }
        return null;
    }

    @Transactional
    public void updateAddressByPrimaryKey(Address address) throws Exception {
        try {
            addressMapper.updateAddressByPrimaryKey(address);
        }catch (Exception e){
            throw new Exception("修改收获地址时出错");
        }
    }


    public List<Address> selectAddressByUserID(String userUuid) throws Exception {
        if (!userUuid.equals("") && !userUuid.equals(null)) {
            List<Address> addresses = addressMapper.selectAddressByUserID(userUuid);
            except(addresses,"用户收获地址查询为空");
            return addresses;
        }
        return null;
    }
    /*------------------------------------------商品类别表------------------------------------------------------------------*/
    public ItemType selectItemTypeByPrimaryKey(Integer itemTypeId) throws Exception {
        if (itemTypeId != 0) {
            ItemType itemType = itemTypeMapper.selectItemTypeByPrimaryKey(itemTypeId);
            except(itemTypeId,"商品类别查询为空");
            return itemType;
        }
        return null;
    }

    public List<ItemType> selectItemTypeAll() throws Exception {
        try {
            return itemTypeMapper.selectItemTypeAll();
        }catch (Exception e){
            throw new Exception("查询所有商品类别时出错");
        }
    }
}
