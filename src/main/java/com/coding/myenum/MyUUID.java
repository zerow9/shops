package com.coding.myenum;

import java.util.UUID;

public enum MyUUID {

    MyUUID();

    private String uuid;

    private MyUUID() {
        this.uuid = UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
