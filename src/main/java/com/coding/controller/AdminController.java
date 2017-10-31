package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.pojo.Address;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController extends UserController {

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;

    /**
     *
     * @param userUuid
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteUserByPrimaryKey")
    public String deleteUserByPrimaryKey(String userUuid)throws Exception{
        adminService.deleteUserByPrimaryKey(userUuid);
        return "";
    }

    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("selectUserAll")
    public String selectUserAll()throws Exception{
        List<User> users = adminService.selectUserAll();
        return "";
    }

    /**
     * 通过分组ID删除分组信息
     * @param groupId
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteGroupsByPrimaryKey")
    public String deleteGroupsByPrimaryKey(Integer groupId)throws Exception{
        adminService.deleteGroupsByPrimaryKey(groupId);
        return "";
    }

    /**
     * 插入分组信息
     * @param groups
     * @return
     * @throws Exception
     */
    @RequestMapping("insertGroups")
    public String insertGroups(Groups groups)throws Exception{
        adminService.insertGroups(groups);
        return "";
    }

    /**
     * 根据分组ID查询分组信息
     * @param groupId
     * @return
     * @throws Exception
     */
    @RequestMapping("selectGroupsByPrimaryKey")
    public String selectGroupsByPrimaryKey(Integer groupId)throws Exception{
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        return "";
    }

    /**
     * 根据分组ID更新分组信息
     * @param groups
     * @return
     * @throws Exception
     */
    @RequestMapping("updateGroupsByPrimaryKey")
    public String updateGroupsByPrimaryKey(Groups groups)throws Exception{
        adminService.updateGroupsByPrimaryKey(groups);
        return "";
    }

    /**
     * 查询所有分组信息
     * @return
     * @throws Exception
     */
    @RequestMapping("selectGroupsAll")
    public String selectGroupsAll()throws Exception{
        List<Groups>groups = adminService.selectGroupsAll();
        return "";
    }

    /**
     * 根据管理员ID删除管理员
     * @param adminId
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteAdminByPrimaryKey")
    public String deleteAdminByPrimaryKey(Integer adminId)throws Exception{
        adminService.deleteAdminByPrimaryKey(adminId);
        return "";
    }

    /**
     * 插入管理员信息
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping("insertAdmin")
    public String insertAdmin(Admin admin)throws Exception{
        adminService.insertAdmin(admin);
        return "";
    }

    /**
     * 通过管理员唯一 ID 查询管理员信息
     * @param adminId
     * @return
     * @throws Exception
     */
    @RequestMapping("selectAdminByPrimaryKey")
    public String selectAdminByPrimaryKey(Integer adminId)throws Exception{
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        return "";
    }

    /**
     * 通过管理员唯一 ID 修改管理员信息
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping("updateAdminByPrimaryKey")
    public String updateAdminByPrimaryKey(Admin admin)throws Exception{
        adminService.updateAdminByPrimaryKey(admin);
        return "";
    }

    /**
     * 查询所有管理员信息
     * @return
     * @throws Exception
     */
    @RequestMapping("selectAdminAll")
    public String selectAdminAll()throws Exception{
        List<Admin> admins = adminService.selectAdminAll();
        return "";
    }
}
