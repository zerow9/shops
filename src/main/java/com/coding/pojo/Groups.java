package com.coding.pojo;

import org.springframework.stereotype.Component;

@Component
public class Groups {
    private Integer groupId;

    private String groupName;

    private String groupJurisdiction;

    public Integer isStart;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupJurisdiction() {
        return groupJurisdiction;
    }

    public void setGroupJurisdiction(String groupJurisdiction) {
        this.groupJurisdiction = groupJurisdiction == null ? null : groupJurisdiction.trim();
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupJurisdiction='" + groupJurisdiction + '\'' +
                '}';
    }
}