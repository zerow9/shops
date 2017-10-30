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
public class AdminServiceImpl implements AdminService {
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
        if (userUuid.equals("") && userUuid.equals(null)) {
            userMapper.deleteUserByPrimaryKey(userUuid);
        }

    }

    @Transactional
    public void insertUser(User user) {
        String id = UUID.randomUUID().toString().replace("-", "_");
        user.setUserUuid(id);
        userMapper.insertUser(user);
    }

    public User selectUserByPrimaryKey(String userUuid) {
        if (userUuid.equals("") && userUuid.equals(null)) {
            return userMapper.selectUserByPrimaryKey(userUuid);
        }
        return null;
    }

    @Transactional
    public void updateUserByPrimaryKey(User user) {
        userMapper.updateUserByPrimaryKey(user);

    }

    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }

    @Transactional
    public void deleteGroupByPrimaryKey(Integer groupId) {
        if (groupId != 0) {
            groupMapper.deleteGroupByPrimaryKey(groupId);
        }
    }

    @Transactional
    public void insertGroup(Group group) {
        groupMapper.insertGroup(group);
    }

    public Group selectGroupByPrimaryKey(Integer groupId) {
        if (groupId != 0) {
            return groupMapper.selectGroupByPrimaryKey(groupId);
        }
        return null;
    }

    @Transactional
    public void updateGroupByPrimaryKey(Group group) {
        groupMapper.updateGroupByPrimaryKey(group);
    }

    public List<Group> selectGroupAll() {
        return groupMapper.selectGroupAll();
    }

    @Transactional
    public void deleteAdminByPrimaryKey(Integer adminId) {
        if (adminId != 0) {
            adminMapper.deleteAdminByPrimaryKey(adminId);
        }
    }

    @Transactional
    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);

    }

    public Admin selectAdminByPrimaryKey(Integer adminId) {
        if (adminId != 0) {
            return adminMapper.selectAdminByPrimaryKey(adminId);
        }
        return null;
    }

    @Transactional
    public void updateAdminByPrimaryKey(Admin admin) {
        adminMapper.updateAdminByPrimaryKey(admin);
    }

    public List<Admin> selectAdminAll() {
        return adminMapper.selectAdminAll();
    }

    @Transactional
    public void deleteAddressByPrimaryKey(Integer addressId) {
        if (addressId != 0) {
            addressMapper.deleteAddressByPrimaryKey(addressId);
        }
    }

    @Transactional
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }

    public Address selectAddressByPrimaryKey(Integer addressId) {
        if (addressId != 0) {
            return addressMapper.selectAddressByPrimaryKey(addressId);
        }
        return null;
    }

    @Transactional
    public void updateAddressByPrimaryKey(Address address) {
        addressMapper.updateAddressByPrimaryKey(address);
    }

    public List<Address> selectAddressAll() {
        return addressMapper.selectAddressAll();
    }
}
