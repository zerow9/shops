package com.coding.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    @Override
    public void setName(String name) {
        super.setName("root");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        String code = "root";
        String userName = (String) token.getPrincipal();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,
                code, this.getName());
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> list = new ArrayList<String>();
        if (userName.equalsIgnoreCase("root")) {
            list.add("del");
            list.add("update");
            list.add("add");
        } else {
            list.add("update");
            list.add("add");
        }
        info.addStringPermissions(list);
        return info;
    }
}
