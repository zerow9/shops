package com.coding.serviceImpl;

import com.coding.Iservice.IAdminService;
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
public class ImplIAdminService extends IUserServiceImpl implements IAdminService {
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
        List<User> users = userMapper.selectUserAll();
        except(users,"用户列表查询为空");
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
            Groups groups = groupsMapper.selectGroupsByPrimaryKey(groupId);
            except(groups,"分组查询为空");
            return groups;
        }
        return null;
    }

    @Transactional
    public void updateGroupsByPrimaryKey(Groups groups) throws Exception {
        groupsMapper.updateGroupsByPrimaryKey(groups);
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
            adminMapper.deleteAdminByPrimaryKey(adminId);
        }
    }

    @Transactional
    public void insertAdmin(Admin admin)  throws Exception{
        adminMapper.insertAdmin(admin);

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
        adminMapper.updateAdminByPrimaryKey(admin);
    }

    public List<Admin> selectAdminAll() throws Exception {
        List<Admin> admins = adminMapper.selectAdminAll();
        except(admins,"管理员列表查询为空");
        return admins;
    }

}
