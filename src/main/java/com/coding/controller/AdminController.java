package com.coding.controller;

import com.coding.Iservice.IAdminService;
import com.coding.comomInterface.DateToString;
import com.coding.comomInterface.MyUUID;
import com.coding.pojo.Admin;
import com.coding.pojo.Groups;
import com.coding.pojo.User;
import com.coding.pojo.templet.JsonFormat;
import net.sf.json.JSONObject;
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
    @ResponseBody
    public boolean deleteUserByPrimaryKey(String userUuid) throws Exception {
        try {
            adminService.deleteUserByPrimaryKey(userUuid);
        } catch (Exception e) {
            throw new Exception("删除用户失败");
        }
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
        return true;
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
    public boolean deleteAdminByPrimaryKey(Integer adminId) throws Exception {
        adminService.deleteAdminByPrimaryKey(adminId);
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
        if (admin == null)
            throw new Exception("插入数据为空");
        admin.setAdminRegisterTime(new Date());
        adminService.insertAdmin(admin);
        return true;
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
    public boolean updateAdminByPrimaryKey(Admin admin, String adminRegisterTime1) throws Exception {
        admin.setAdminRegisterTime(DateToString.toDate(adminRegisterTime1));
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
    public String getAdminAll() throws Exception {
        List<Admin> admins = adminService.selectAdminAll();
        for (Admin admin : admins)
            admin.setDateToString(DateToString.change(admin.getAdminRegisterTime()));
        JsonFormat<Admin> json = new JsonFormat<>(admins, admins.size(), null, null);
        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
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
    public String getUserAll() throws Exception {
        List<User> users = adminService.selectUserAllPaging(0, 10);
        for (User user : users)
            user.setDateToString(DateToString.change(user.getUserRegisterDateTime()));
        JsonFormat<User> json = new JsonFormat<>(users, users.size(), null, null);
        JSONObject result = JSONObject.fromObject(json);
        return result.toString();
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
    public String updateAdmin(Integer id, Model model) {
        try {
            Admin admin = adminService.selectAdminByPrimaryKey(id);
            admin.setDateToString(DateToString.change(admin.getAdminRegisterTime()));
            model.addAttribute("admin", admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return true;
    }

    @RequestMapping("addUser")
    public String addUser() {
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
        user.setDateToString(DateToString.change(user.getUserRegisterDateTime()));
        model.addAttribute("user", user);
        return "users/updateUser";
    }


    @RequestMapping("deleteUserByUUidArray")
    public boolean deleteUserByUUidArray(String arrayString) throws Exception {
        adminService.deleteUsersByUuidArray(arrayString.split(","));
        return true;
    }

    @RequestMapping("updateUserByPrimaryKey")
    public boolean updateUserByPrimaryKey(String userRegisterDateTime1,User user) throws Exception {
        user.setUserRegisterDateTime(DateToString.toDate(userRegisterDateTime1));
        user.setUserCurrentTime(new Date());
        user.setUserLandIp(InetAddress.getLocalHost().getHostAddress());
        int landNumber = user.getUserLandNumber();
        user.setUserLandNumber(landNumber+1);
        adminService.updateUserByPrimaryKey(user);
        return true;
    }

    @RequestMapping("updateUser")
    public String updateUser(String userUuid, Model model) throws Exception {
        User user = adminService.selectUserByPrimaryKey(userUuid);
        user.setDateToString(DateToString.change(user.getUserRegisterDateTime()));
        model.addAttribute("user", user);
        return "users/updateUser";

    }

    @RequestMapping("seeUserIdByKey")
    public String seeUserIdByKey(String userUuid, Model model) throws Exception {
        User user = adminService.selectUserByPrimaryKey(userUuid);
        user.setDateToString(DateToString.change(user.getUserRegisterDateTime()));
        model.addAttribute("user", user);
        return "users/detailUser";
    }

    @RequestMapping("seeAdminIdByKey")
    public String seeAdminIdByKey(Integer adminId, Model model) throws Exception {
        Admin admin = adminService.selectAdminByPrimaryKey(adminId);
        admin.setDateToString(DateToString.change(admin.getAdminRegisterTime()));
        model.addAttribute("admin", admin);
        return "admins/detailAdmin";
    }

}
