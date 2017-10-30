package com.coding.serviceImpl;

import com.coding.Iservice.AdminService;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.AdminMapper;
import com.coding.mapper.GroupMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import com.coding.pojo.Group;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Transactional
    public void deleteUserByPrimaryKey(String userUuid) {
        if (userUuid!=""&&userUuid!=null){
            userMapper.deleteUserByPrimaryKey(userUuid);
        }

    }

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

    public List<User> selectUserAll() {
        List<User> users = userMapper.selectUserAll();
        return users;
    }

    @Transactional
    public void deleteGroupByPrimaryKey(Integer groupId) {
        if (groupId!=0&&groupId!=null){
            groupMapper.deleteGroupByPrimaryKey(groupId);
        }
    }

    @Transactional
    public void insertGroup(Group group) {
        groupMapper.insertGroup(group);
    }

    public Group selectGroupByPrimaryKey(Integer groupId) {
        if (groupId!=0&&groupId!=null){
            Group group=groupMapper.selectGroupByPrimaryKey(groupId);
            return  group;
        }
        return null;
    }

    @Transactional
    public void updateGroupByPrimaryKey(Group group) {
        groupMapper.updateGroupByPrimaryKey(group);
    }

    public List<Group> selectGroupAll() {
        List<Group> groups = groupMapper.selectGroupAll();
        return groups;
    }

    @Transactional
    public void deleteAdminByPrimaryKey(Integer adminId) {
        if (adminId!=0&&adminId!=null){
            adminMapper.deleteAdminByPrimaryKey(adminId);
        }
    }

    @Transactional
    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);

    }

    public Admin selectAdminByPrimaryKey(Integer adminId) {
        if (adminId!=0&&adminId!=null){
            Admin admin = adminMapper.selectAdminByPrimaryKey(adminId);
            return  admin;
        }
        return null;
    }

    @Transactional
    public void updateAdminByPrimaryKey(Admin admin) {
        adminMapper.updateAdminByPrimaryKey(admin);
    }

    public List<Admin> selectAdminAll() {
        List<Admin> admins = adminMapper.selectAdminAll();
        return admins;
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
