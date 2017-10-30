package com.coding.pojo;

public class Group {
    private Integer groupId;

    private String groupName;

    private String groupJurisdiction;


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

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupJurisdiction='" + groupJurisdiction + '\'' +
                '}';
    }
}