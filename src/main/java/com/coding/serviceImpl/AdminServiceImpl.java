package com.coding.serviceImpl;

import com.coding.Iservice.IAdminService;
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

@Service("adminService")
public class AdminServiceImpl extends UserServiceImpl implements IAdminService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private GroupsMapper groupsMapper;
    @Autowired
    private AdminMapper adminMapper;

    /*------------------------------------------用户表------------------------------------------------------------------*/
    @Transactional
    public void deleteUserByPrimaryKey(String userUuid)  throws Exception{
        if (!userUuid.equals("") && !userUuid.equals(null)) {
            try {
                userMapper.deleteUserByPrimaryKey(userUuid);
            }catch (Exception e){
                throw new Exception("删除用户信息时出错");
            }
        }
    }

    public List<User> selectUserAll()  throws Exception{
        List<User> users = userMapper.selectUserAll();
        except(users,"用户列表查询为空");
        return userMapper.selectUserAll();
    }

    /*------------------------------------------收获地址表------------------------------------------------------------------*/
    public List<Address> selectAddressAll() throws Exception {
        try {
            return addressMapper.selectAddressAll();
        }catch (Exception e){
            throw new Exception("查询全部收获地址表出错");
        }
    }
    /*------------------------------------------分组表------------------------------------------------------------------*/
    @Transactional
    public void deleteGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != 0) {
            try {
                groupsMapper.deleteGroupsByPrimaryKey(groupId);
            }catch (Exception e){
                throw new Exception("删除分组信息时出错");
            }
        }
    }

    @Transactional
    public void insertGroups(Groups groups)  throws Exception{
        try {
            groupsMapper.insertGroups(groups);
        }catch (Exception e){
            throw new Exception("插入分组信息时出错");
        }
    }

    public Groups selectGroupsByPrimaryKey(Integer groupId)  throws Exception{
        if (groupId != 0) {
            Groups groups = groupsMapper.selectGroupsByPrimaryKey(groupId);
            except(groups,"分组查询为空");
            return groups;
        }
        return null;
    }

    @Transactional
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception {
        try {
            groupsMapper.updateGroupsByPrimaryKey(groups);
        }catch (Exception e){
            throw new Exception("修改分组信息时出错");
        }
    }

    public List<Groups> selectGroupsAll() throws Exception {
        List<Groups> groups = groupsMapper.selectGroupsAll();
        except(groups,"分组列表查询为空");
        return groups;
    }

    /*------------------------------------------管理员表------------------------------------------------------------------*/
    @Transactional
    public void deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        if (adminId != 0) {
            try {
                adminMapper.deleteAdminByPrimaryKey(adminId);
            }catch (Exception e){
                throw new Exception("删除管理员时出错");
            }
        }
    }

    @Transactional
    public void insertAdmin(Admin admin)  throws Exception{
        try {
            adminMapper.insertAdmin(admin);
        }catch (Exception e){
            throw new Exception("插入管理员时出错");
        }
    }

    public Admin selectAdminByPrimaryKey(Integer adminId)  throws Exception{
        if (adminId != 0) {
            Admin admin = adminMapper.selectAdminByPrimaryKey(adminId);
            except(admin,"管理员查询为空");
            return admin;
        }
        return null;
    }

    @Transactional
    public void updateAdminByPrimaryKey(Admin admin)  throws Exception{
        try {
            adminMapper.updateAdminByPrimaryKey(admin);
        }catch (Exception e){
            throw new Exception("修改管理员信息时出错");
        }
    }

    public List<Admin> selectAdminAll() throws Exception {
        List<Admin> admins = adminMapper.selectAdminAll();
        except(admins,"管理员列表查询为空");
        return admins;
    }

}
