package com.coding.serviceImpl;

import com.coding.Iservice.AdminService;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.AdminMapper;
import com.coding.mapper.GroupsMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private GroupsMapper groupsMapper;
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

    public void updateUserByPrimaryKey(User user) {

    }

    public List<User> selectUserAll() {
        return null;
    }

    public void deleteGroupByPrimaryKey(Integer groupId) {

    }

    public void insertGroup(Groups groups) {

    }

    public Groups selectGroupByPrimaryKey(Integer groupId) {
        return null;
    }

    public void updateGroupByPrimaryKey(Groups groups) {

    }

    public List<Groups> selectGroupAll() {
        return null;
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

    public void updateAdminByPrimaryKey(Admin admin, Integer adminId) {

    }

    public List<Admin> selectAdminAll() {
        return null;
    }

    public void deleteAddressByPrimaryKey(Integer addressId) {


    }

    public void insertAddress(Address address) {

    }

    public Address selectAddressByPrimaryKey(Integer addressId) {
        return null;
    }

    public void updateAddressByPrimaryKey(Address address, Integer addressId) {

    }

    public List<Address> selectAddressAll() {
        return null;
    }
}
