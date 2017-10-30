package com.coding.mapper;

import com.coding.pojo.Group;

import java.util.List;

public interface GroupMapper {
    /**
     * 通过分组 ID 删除分组信息
     * @param groupId
     */
    public void deleteByPrimaryKey(Integer groupId);

    /**
     * 插入分组信息
     * @param group
     */
    public void insert(Group group);

    /**
     * 根据分组 ID 查询分组信息
     * @param groupId
     * @return
     */
    public Group selectByPrimaryKey(Integer groupId);

    /**
     * 根据分组 ID 更新分组信息
     * @param group
     */
    public void updateByPrimaryKey(Group group);

    /**
     * 查询所有分组信息
     * @return
     */
    public List<Group> selectAll();

}