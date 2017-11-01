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

@Controller()
@RequestMapping("/admin")
public class AdminController extends UserController {

    @Autowired
    @Qualifier("adminService")
    private IAdminService adminService;


    /**
     * 根据用户uuid删除用户
     *
     * @param userUuid 用户uuid
     * @return 删除成功之后跳转页面
     * @throws Exception 删除用户删除异常
     */
    @RequestMapping("deleteUserByPrimaryKey")
    public String deleteUserByPrimaryKey(String userUuid) throws Exception {
        try {
            adminService.deleteUserByPrimaryKey(userUuid);
        } catch (Exception e) {
            throw new Exception("删除用户失败");
        }
        return "";
    }


    /**
     * 查询所有用户信息
     *
     * @return 查询用户后跳转的页面
     * @throws Exception 查询失败异常
     */
    @RequestMapping("selectUserAll")
    public String selectUserAll() throws Exception {
        List<User> users = adminService.selectUserAll();
        return "";
    }


    /**
     * 通过分组ID删除分组信息
     *
     * @param groupId 分组id
     * @return 删除分组后跳转的页面
     * @throws Exception 删除分组异常
     */
    @RequestMapping("deleteGroupsByPrimaryKey")
    public String deleteGroupsByPrimaryKey(Integer groupId) throws Exception {
        try {
            adminService.deleteGroupsByPrimaryKey(groupId);
        } catch (Exception e) {
            throw new Exception("删除分组异常");
        }
        return "";
    }

    /**
     * 插入分组信息
     *
     * @param groups 一组信息
     * @return 插入成功的页面
     * @throws Exception 插入失败
     */
    @RequestMapping("insertGroups")
    public String insertGroups(Groups groups) throws Exception {
        try {
            adminService.insertGroups(groups);
        } catch (Exception e) {
            throw new Exception("增加分组失败");
        }
        return "";
    }

    /**
     * 根据分组ID查询分组信息
     *
     * @param groupId 分组id
     * @return 查找一组id的信息页面
     */
    @RequestMapping("selectGroupsByPrimaryKey")
    public String selectGroupsByPrimaryKey(Integer groupId) throws Exception {
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        return "";
    }

    /**
     * 根据分组ID更新分组信息
     *
     * @param groups 更新的分组信息
     * @return 更新成功之后的页面
     */
    @RequestMapping("updateGroupsByPrimaryKey")
    public String updateGroupsByPrimaryKey(Groups groups) throws Exception {
        adminService.updateGroupsByPrimaryKey(groups);
        return "";
    }

    /**
     * 查询所有分组信息
     *
     * @return 查询所有信息
     */
    @RequestMapping("selectGroupsAll")
    public String selectGroupsAll() throws Exception {
        List<Groups> groups = adminService.selectGroupsAll();
        return "";
    }

    /**
     * 根据超级管理员权限删除分组管理员
     *
     * @param adminId 分组管理员ID
     * @return 删除成功后跳过的页面
     */
    @RequestMapping("deleteAdminByPrimaryKey")
    public String deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        adminService.deleteAdminByPrimaryKey(adminId);
        return "";
    }

    /**
     * 插入分组管理员信息
     *
     * @param admin 分组管理员
     * @return 插入后的跳转页面
     * @throws Exception 插入数据为空
     */
    @RequestMapping("insertAdmin")
    public String insertAdmin(Admin admin) throws Exception {
        if (admin == null)
            throw new Exception("插入数据为空");
        adminService.insertAdmin(admin);
        return "";
    }

    /**
     * 通过超级管理员的权限查询分组管理员信息
     *
     * @param adminId 分组管理员id
     * @return 查询分组管理员信息跳转的页面
     */
    @RequestMapping("selectAdminByPrimaryKey")
    public String selectAdminByPrimaryKey(Integer adminId) throws Exception {
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        return "";
    }

    /**
     * 通过超级管理员权限来修改管理员信息
     *
     * @param admin 分组管理员信息
     * @return 修改成功和跳转的页面
     */
    @RequestMapping("updateAdminByPrimaryKey")
    public String updateAdminByPrimaryKey(Admin admin) throws Exception {
        adminService.updateAdminByPrimaryKey(admin);
        return "";
    }

    /**
     * 查询所有管理员信息
     *
     * @return 插入成功之后的页面
     */
    @RequestMapping("selectAdminAll")
    public String selectAdminAll() throws Exception {
        List<Admin> admins = adminService.selectAdminAll();
        return "";
    }

}
