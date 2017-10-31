package com.coding.serviceImpl;

import com.coding.Iservice.IAdminServiceI;
import com.coding.mapper.AddressMapper;
import com.coding.mapper.AdminMapper;
import com.coding.mapper.GroupsMapper;
import com.coding.mapper.UserMapper;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IAdminServiceImplI extends IUserServiceImpl implements IAdminServiceI {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupsMapper groupsMapper;
    @Autowired
    private AdminMapper adminMapper;

    /*------------------------------------------用户表------------------------------------------------------------------*/
    @Transactional
    public void deleteUserByPrimaryKey(String userUuid)  throws Exception{
        if (userUuid.equals("") && userUuid.equals(null)) {
            userMapper.deleteUserByPrimaryKey(userUuid);
        }
    }

    public List<User> selectUserAll()  throws Exception{
        return userMapper.selectUserAll();
    }

    /*------------------------------------------分组表------------------------------------------------------------------*/
    @Transactional
    public void deleteGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != 0) {
            groupsMapper.deleteGroupsByPrimaryKey(groupId);
        }
    }

    @Transactional
    public void insertGroups(Groups groups)  throws Exception{
        groupsMapper.insertGroups(groups);
    }

    public Groups selectGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != 0) {
            return groupsMapper.selectGroupsByPrimaryKey(groupId);
        }
        return null;
    }

    @Transactional
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception {
        groupsMapper.updateGroupsByPrimaryKey(groups);
    }

    public List<Groups> selectGroupsAll() throws Exception {
        return groupsMapper.selectGroupsAll();
    }

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    @Transactional
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        if (adminId != 0) {
            adminMapper.deleteAdminByPrimaryKey(adminId);
        }
    }

    @Transactional
    public void insertAdmin(Admin admin)  throws Exception{
        adminMapper.insertAdmin(admin);

    }

    public Admin selectAdminByPrimaryKey(Integer adminId)  throws Exception{
        if (adminId != 0) {
            return adminMapper.selectAdminByPrimaryKey(adminId);
        }
        return null;
    }

    @Transactional
    public void updateAdminByPrimaryKey(Admin admin)  throws Exception{
        adminMapper.updateAdminByPrimaryKey(admin);
    }

    public List<Admin> selectAdminAll() throws Exception {
        return adminMapper.selectAdminAll();
    }

}
