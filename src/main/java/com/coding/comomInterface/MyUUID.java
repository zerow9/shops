package com.coding.comomInterface;

import java.util.UUID;

public class MyUUID {

    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
