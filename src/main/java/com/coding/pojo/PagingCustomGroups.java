package com.coding.pojo;

import org.springframework.stereotype.Component;

@Component
public class PagingCustomGroups extends Paging {
    private Groups groups;

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
