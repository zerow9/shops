package com.coding.mapper;

import com.coding.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户 ID 删除用户信息
     * @param userUuid
     */
    public void deleteUserByPrimaryKey(String userUuid);

    /**
     * 插入一条用户信息
     * @param user
     */
    public void insertUser(User user);

    /**
     * 通过用户唯一 ID 查询用户信息
     * @param userUuid
     * @return
     */
    public User selectUserByPrimaryKey(String userUuid);

    /**
     * 根据用户唯一 ID 更新用户信息
     * @param user
     */
    public void  updateUserByPrimaryKey(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> selectUserAll();
}