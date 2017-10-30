package com.coding.controller;

import com.coding.mapper.GroupsMapper;
import com.coding.pojo.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Test {

    @Autowired
    private GroupsMapper groupsMapper;

    @RequestMapping("test")
    public void insertGroup() {
        Groups groups = new Groups();
        groups.setGroupJurisdiction("321312");
        groups.setGroupName("用户组");

        groupsMapper.insertGroups(groups);
    }

    @RequestMapping("test1")
    public void deleteGroupsByPrimaryKey() {
        groupsMapper.deleteGroupsByPrimaryKey(2);
    }


    @RequestMapping("test2")
    public void updateGroupsByPrimaryKey() {
        Groups groups = new Groups();
        groups.setGroupId(3);
        groups.setGroupJurisdiction("3");
        groups.setGroupName("3");
        groupsMapper.updateGroupsByPrimaryKey(groups);
    }

    @RequestMapping("test3")
    public void selectGroupsByPrimaryKey() {
        Groups groups = groupsMapper.selectGroupsByPrimaryKey(1);
        System.out.println(groups);
    }
    @RequestMapping("test4")
    public void selectGroupsAll() {
        List<Groups> groups = groupsMapper.selectGroupsAll();
        System.out.println(groups);
    }
}
