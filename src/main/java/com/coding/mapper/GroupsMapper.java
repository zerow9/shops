package com.coding.mapper;

import com.coding.pojo.Groups;
import com.coding.paging.PagingCustomGroups;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupsMapper {
    /**
     * 通过分组 ID 删除分组信息
     * @param groupId 分组唯一ID
     */
    public int deleteGroupsByPrimaryKey(Integer groupId) throws Exception;

    /**
     * 批量删除用户组
     * @return 是否删除成功 非0:成功 0:不成功
     * @throws Exception
     */
    public int deleteGroupsByPrimaryKeyArray(@Param("groups_idArray") Integer [] groups_idArray) throws Exception;


    /**
     * 插入分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public int insertGroups(Groups groups) throws Exception;

    /**
     * 根据分组 ID 查询分组信息
     * @param groupId 分组唯一ID
     * @return  封装了分组信息的 Groups 对象
     */
    public Groups selectGroupsByPrimaryKey(@Param("groupId") Integer groupId) throws Exception;

    /**
     * 根据分组 ID 更新分组信息
     * @param groups 封装了分组信息的 Groups 对象
     */
    public int updateGroupsByPrimaryKey(Groups groups) throws Exception;

    /**
     * 查询所有分组信息
     * @return 封装了分组信息的 Groups 对象 集合
     */
    public List<Groups> selectGroupsAll() throws Exception;

    /**
     * 用户组查询功能模块（包含主键查询、权限查询、状态查询、组别名查询、分页功能）
     * @return 封装了用户组信息的 Groups 类对象集合
     * @throws Exception
     */
    public List<Groups> selectGroups(PagingCustomGroups pagingCustomGroups) throws Exception;

    /**
     * 查询表中共有多少条数据
     * @return 返回分组表中一共有多少条数据
     * @throws Exception
     */
    public Integer selectGroupsCount()throws Exception;
}