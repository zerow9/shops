package com.coding.comomInterface;

import javax.servlet.http.HttpServletRequest;

public class JavaGet {

    public static String charsetGet(String charset, HttpServletRequest request) throws Exception {
        if(charset!=null)
        return new String(charset.getBytes("iso-8859-1"), "utf-8");
        return null;
    }

}
