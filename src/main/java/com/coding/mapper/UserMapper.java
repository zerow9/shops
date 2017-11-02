package com.coding.mapper;

import com.coding.pojo.PagingCustom;
import com.coding.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户 ID 删除用户信息
     *
     * @param userUuid 用户唯一ID
     */
    public int deleteUserByPrimaryKey(String userUuid) throws Exception;

    /**
     * 插入一条用户信息
     *
     * @param user 封装了用户信息的 User 对象
     */
    public int insertUser(User user);

    /**
     * 通过用户唯一 ID 查询用户信息
     *
     * @param userUuid 封装了用户信息的 User 对象
     * @return 封装了用户信息的 User 对象
     */
    public User selectUserByPrimaryKey(@Param("userUuid") String userUuid) throws Exception;

    /**
     * 根据用户唯一 ID 更新用户信息
     *
     * @param user 封装了用户信息的 User 对象
     */
    public int updateUserByPrimaryKey(User user) throws Exception;

    /**
     * 查询所有用户信息
     *
     * @return 返回一个装有 封装用户信息的 User 类的集合
     */
    public List<User> selectUserAll() throws Exception;

    /**
     * 根据电话号码查找用户信息
     *
     * @param userPhone 电话号码
     * @return 封装了符合查找条件的 User 类对象
     * @throws Exception
     */
    public User selectUserByPhone(@Param("userPhone") String userPhone) throws Exception;

    /**
     * 根据组别ID查找用户信息
     *
     * @param user_group 组别ID
     * @return 返回满足查询条件封装类用户信息的 User 类对象集合
     * @throws Exception
     */
    public List<User> selectUserByGroupId(@Param("user_group") Integer user_group) throws Exception;

    /**
     * 根据积分范围查找用户信息
     *
     * @param former 范围低数值
     * @param latter 范围高数值
     * @return 封装了满足查询条件的 User 类对象集合
     */
    public List<User> selectUserByScoreRange(@Param("former") Integer former, @Param("latter") Integer latter) throws Exception;


    /**
     * 根据年龄范围查询用户信息
     *
     * @param former 范围低数值
     * @param latter 范围高数值
     * @return 封装了满足查询条件的 User 类对象集合
     */
    public List<User> selectUserByAgeRange(@Param("former") Integer former, @Param("latter") Integer latter) throws Exception;

    /**
     * 批量删除用户信息
     *
     * @param user_uuidArray 需删除用户ID集合
     * @return 1 ：删除成功  0 ：删除失败
     * @throws Exception
     */
    public int deleteUsersByUuidArray(@Param("user_uuidArray") String[] user_uuidArray) throws Exception;

    /**
     * 通过分页查询所有用户信息
     *
     * @param nowPage 当前页面
     * @param number  每页需要查询的用户数量
     * @return 封装了用户信息的 User 类对象集合
     * @throws Exception
     */
    public List<User> selectUserAllPaging(@Param("nowPage") Integer nowPage, @Param("number") Integer number) throws Exception;


    /**
     * 通过关键字查询并分页显示用户信息
     *
     * @param pagingCustom 封装了分页信息的 PagingCustom 类对象
     * @return 封装了用户信息的 User 类对象集合
     * @throws Exception
     */
    public List<User> selectUserPagingByKeyWord(PagingCustom pagingCustom) throws Exception;

}