package com.coding.mapper;

import com.coding.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户 ID 删除用户信息
     * @param userUuid  用户唯一ID
     */
    public void deleteUserByPrimaryKey(String userUuid) throws Exception;

    /**
     * 插入一条用户信息
     * @param user  封装了用户信息的 User 对象
     */
    public void insertUser(User user);

    /**
     * 通过用户唯一 ID 查询用户信息
     * @param userUuid  封装了用户信息的 User 对象
     * @return  封装了用户信息的 User 对象
     */
    public User selectUserByPrimaryKey(@Param("userUuid") String userUuid) throws Exception;

    /**
     * 根据用户唯一 ID 更新用户信息
     * @param user  封装了用户信息的 User 对象
     */
    public void  updateUserByPrimaryKey(User user) throws Exception;

    /**
     * 查询所有用户信息
     * @return  返回一个装有 封装用户信息的 User 类的集合
     */
    public List<User> selectUserAll() throws Exception;
}