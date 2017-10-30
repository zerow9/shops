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
    private GroupsMapper groupsMapper;
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
    public void deleteGroupsByPrimaryKey(Integer groupId) {
        if (groupId != 0) {
            groupsMapper.deleteGroupsByPrimaryKey(groupId);
        }
    }

    @Transactional
    public void insertGroups(Groups groups) {
        groupsMapper.insertGroups(groups);
    }

    public Groups selectGroupsByPrimaryKey(Integer groupId) {
        if (groupId != 0) {
            return groupsMapper.selectGroupsByPrimaryKey(groupId);
        }
        return null;
    }

    @Transactional
    public void updateGroupsByPrimaryKey(Groups groups) {
        groupsMapper.updateGroupsByPrimaryKey(groups);
    }

    public List<Groups> selectGroupsAll() {
        return groupsMapper.selectGroupsAll();
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
