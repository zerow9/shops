package com.coding.mapper;

import com.coding.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户 ID 删除用户信息
     * @param userUuid
     */
    public void deleteByPrimaryKey(String userUuid);

    /**
     * 插入一条用户信息
     * @param user
     */
    public void insert(User user);

    /**
     * 通过用户唯一 ID 查询用户信息
     * @param userUuid
     * @return
     */
    public User selectByPrimaryKey(String userUuid);

    /**
     * 根据用户唯一 ID 更新用户信息
     * @param user
     */
    public void  updateByPrimaryKey(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> selectAll();
}