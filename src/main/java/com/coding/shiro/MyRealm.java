package com.coding.shiro;

import java.util.ArrayList;
import java.util.List;

import com.coding.Iservice.IAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IAdminService adminService;

    @Override
    public void setName(String name) {
        super.setName("root");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePassword = (UsernamePasswordToken) token;
        String userName = usernamePassword.getUsername();
        String code = "";
        char[] c = usernamePassword.getPassword();
        if (userName.equalsIgnoreCase("root")) {
            code = "root";
        } else {
            try {
                List<String> list = adminService.selectAdminPassword(userName);
                for (String str : list)
                    if (str.equals(new String(c))) {
                        code = new String(c);
                        break;
                    }
            } catch (Exception e) {
            }
        }
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
            list.add("root");
        } else {
            list.add("update");
            list.add("add");
            list.add("del");
        }
        info.addStringPermissions(list);
        return info;
    }

    public void clearCache() {
        super.clearCache(SecurityUtils.getSubject().getPrincipals());
    }
}
