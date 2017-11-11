package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.comomInterface.MyUUID;
import com.coding.json.MyJsonConfig;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Integer count = null;
    private Integer counts = null;
    private Integer countGroups = null;

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
    public boolean deleteUserByPrimaryKey(String userUuid) throws Exception {
        adminService.deleteUserByPrimaryKey(userUuid);
        count--;
        return true;
    }

    /**
     * 通过分组ID删除分组信息
     *
     * @param groupId 分组id
     * @return 删除分组后跳转的页面
     * @throws Exception 删除分组异常
     */
    @RequestMapping("deleteGroupsByPrimaryKey")
    @RequiresPermissions("root")
    public boolean deleteGroupsByPrimaryKey(Integer groupId) throws Exception {
        try {
            adminService.deleteGroupsByPrimaryKey(groupId);
        } catch (Exception e) {
            throw new Exception("删除分组异常");
        }
        countGroups--;
        return true;
    }

    /**
     * 插入分组信息
     *
     * @param groups 一组信息
     * @return 插入成功的页面
     * @throws Exception 插入失败
     */
    @RequestMapping("insertGroups")
    public boolean insertGroups(Groups groups) throws Exception {
        try {
            adminService.insertGroups(groups);
        } catch (Exception e) {
            throw new Exception("增加分组失败");
        }
        countGroups++;
        return true;
    }


    /**
     * 批量删除管理员
     *
     * @param arrayString 管理员id集合
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteAdminsByIdArray")
    public boolean deleteAdminsByIdArray(String arrayString) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (String uuid : arrayString.split(","))
            list.add(Integer.parseInt(uuid));
        adminService.deleteAdminByAdminIdArray(list.toArray(new Integer[list.size()]));
        counts -= list.size();
        return true;
    }


    /**
     * 查询所有分组信息
     *
     * @return 查询所有信息
     */
    @RequestMapping("selectGroupsAll")
    public String selectGroupsAll() throws Exception {
        return "groups/groupsList";
    }

    /**
     * 根据超级管理员权限删除分组管理员
     *
     * @param adminId 分组管理员ID
     * @return 删除成功后跳过的页面
     */
    @RequestMapping("deleteAdminByPrimaryKey")
    public boolean deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        adminService.deleteAdminByPrimaryKey(adminId);
        counts--;
        return true;
    }


    /**
     * 插入分组管理员信息
     *
     * @param admin 分组管理员
     * @return 插入后的跳转页面
     * @throws Exception 插入数据为空
     */
    @RequestMapping("insertAdmin")
    public boolean insertAdmin(Admin admin) throws Exception {
        admin.setAdminRegisterTime(new Date());
        adminService.insertAdmin(admin);
        counts++;
        return true;
    }


    /**
     * 通过超级管理员权限来修改管理员信息
     *
     * @param admin 分组管理员信息
     * @return 修改成功和跳转的页面
     */
    @RequestMapping("updateAdminByPrimaryKey")
    public boolean updateAdminByPrimaryKey(Admin admin, String adminRegisterTime1) throws Exception {
        admin.setAdminRegisterTime(DateToString.date(adminRegisterTime1));
        adminService.updateAdminByPrimaryKey(admin);
        return true;
    }

    /**
     * 查询所有管理员信息
     *
     * @return 插入成功之后的页面
     */
    @RequestMapping("selectAdminAll")
    public String selectAdminAll(Model model) throws Exception {
        return "admins/adminlist";
    }

    @RequestMapping("getAdminAll")
    @ResponseBody
    public String getAdminAll(Integer page, Integer limit) throws Exception {
        if (counts == null)
            counts = adminService.selectAdminCount();
        List<Admin> admins = adminService.selectAdminAllPaging((page - 1) * limit, limit);
        for (Admin admin : admins)
            admin.setDateToString(DateToString.date(admin.getAdminRegisterTime()));
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(admins, counts);
    }

    /**
     * 查询所有用户信息
     *
     * @return 查询用户后跳转的页面
     * @throws Exception 查询失败异常
     */
    @RequestMapping("selectUserAll")
    public String selectUserAll() throws Exception {
        return "users/userlist";
    }

    /**
     * 返回 JSON 的方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("getUserJson")
    @ResponseBody
    public String getUserAll(Integer page, Integer limit) throws Exception {
        if (count == null)
            count = adminService.selectUserCount();
        List<User> users = adminService.selectUserAllPaging((page - 1) * limit, limit);
        for (User user : users)
            user.setDateToString(DateToString.date(user.getUserRegisterDateTime()));
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(users, count);
    }

    @RequestMapping("getGroupsJson")
    @ResponseBody
    public String getGroupsJson(Integer page, Integer limit) throws Exception {
        if (countGroups == null)
            countGroups = adminService.selectGroupsCount();
        List<Groups> groups = adminService.selectGroupsPaging((page - 1) * limit, limit);
        MyJsonConfig myJsonConfig = new MyJsonConfig();
        return myJsonConfig.start(groups, countGroups);
    }

    @RequestMapping("addAdmin")
    public String addAdmin() {
        return "admins/addadmin";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateAdmin")
    public String updateAdmin(Integer id, Model model) throws Exception {
        Admin admin = adminService.selectAdminByPrimaryKey(id);
        admin.setDateToString(DateToString.date(admin.getAdminRegisterTime()));
        model.addAttribute("admin", admin);
        return "admins/updateadmin";
    }


    @RequestMapping("insertUser")
    public boolean insertUser(User user) throws Exception {
        user.setUserRegisterDateTime(new Date());
        user.setUserAge(111);
        user.setUserLandNumber(11);
        user.setUserCurrentTime(new Date());
        user.setUserLandIp(InetAddress.getLocalHost().getHostAddress());
        user.setUserUuid(MyUUID.randomUUID());
        user.setUserAddress(111111);
        System.out.println(user);
        adminService.insertUser(user);
        count++;
        return true;
    }

    @RequestMapping("addUser")
    public String addUser(Model model)throws  Exception {
        List<Groups> groups = adminService.selectGroupsAll();
        model.addAttribute("groups", groups);
        return "users/adduser";
    }


    /**
     * 根据UUID查询用户信息
     *
     * @param userUuid
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("selectUserIdByKey")
    public String selectUserIdByKey(String userUuid, Model model) throws Exception {
        User user = adminService.selectUserByPrimaryKey(userUuid);
        user.setDateToString(DateToString.date(user.getUserRegisterDateTime()));
        List<Groups> groups = adminService.selectGroupsAll();
        model.addAttribute("groups", groups);
        model.addAttribute("user", user);
        return "users/updateUser";
    }


    @RequestMapping("deleteUserByUUidArray")
    public boolean deleteUserByUUidArray(String arrayString) throws Exception {
        String[] strings = arrayString.split(",");
        adminService.deleteUsersByUuidArray(strings);
        count -= strings.length;
        return true;
    }


    @RequestMapping("updateUserByPrimaryKey")
    public boolean updateUserByPrimaryKey(User user) throws Exception {
        user.setUserCurrentTime(new Date());
        user.setUserLandIp(InetAddress.getLocalHost().getHostAddress());
        int landNumber = user.getUserLandNumber();
        user.setUserLandNumber(landNumber + 1);
        adminService.updateUserByPrimaryKey(user);
        return true;
    }

    @RequestMapping("seeUserIdByKey")
    public String seeUserIdByKey(String userUuid, Model model) throws Exception {
        User user = adminService.selectUserByPrimaryKey(userUuid);
        user.setDateToString(DateToString.date(user.getUserRegisterDateTime()));
        List<Groups> groups = adminService.selectGroupsAll();
        model.addAttribute("groups", groups);
        model.addAttribute("user", user);
        return "users/detailUser";
    }

    @RequestMapping("seeAdminIdByKey")
    public String seeAdminIdByKey(Integer adminId, Model model) throws Exception {
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        admin.setDateToString(DateToString.date(admin.getAdminRegisterTime()));
        model.addAttribute("admin", admin);
        return "admins/detailAdmin";
    }

    @RequestMapping("addGroups")
    public String addGroups() {
        return "groups/groupsAdd";
    }

    /**
     * 批量删除用户组
     *
     * @param arrayString 用户组id集合
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteGroupsByIdArray")
    @RequiresPermissions("root")
    public boolean deleteGroupsByIdArray(String arrayString) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (String uuid : arrayString.split(","))
            list.add(Integer.parseInt(uuid));
        adminService.deleteGroupsByPrimaryKeyArray(list.toArray(new Integer[list.size()]));
        countGroups -= list.size();
        return true;
    }

    /**
     * 查看用户组
     *
     * @param groupId 用户组ID
     * @return 用户组详情页
     */
    @RequestMapping("detailGroupsIdByKey")
    public String detailGroupsIdByKey(Integer groupId, Model model) throws Exception {
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        model.addAttribute("groups", groups);
        return "groups/groupsDetail";
    }

    /**
     * 更改用户组
     *
     * @param groupId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("updateGroups")
    public String updateGroups(Integer groupId, Model model) throws Exception {
        Groups groups = adminService.selectGroupsByPrimaryKey(groupId);
        model.addAttribute("groups", groups);
        return "groups/groupsUpdate";
    }


    /**
     * 更改是否成功
     *
     * @param groups
     * @return
     * @throws Exception
     */
    @RequestMapping("updateGroupsByPrimaryKey")
    public boolean updateGroupsByPrimaryKey(Groups groups) throws Exception {
        System.out.println(groups);
        adminService.updateGroupsByPrimaryKey(groups);
        return true;
    }
}
