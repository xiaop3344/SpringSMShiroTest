package com.xdl.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import com.xdl.bean.User;
import com.xdl.mapper.ShiroMapper;
import com.xdl.service.LoginService;
import com.xdl.util.DecriptUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


public class MyShiroRealm extends AuthorizingRealm {

    //这里因为没有调用后台，直接默认只有一个用户("likang"，"123123")
    /*private static final String USER_NAME = "likang";
    private static final String PASSWORD = "123123";*/


    @Autowired
    private LoginService loginService;


    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = principals.getPrimaryPrincipal().toString();

        Set<String> roles = loginService.findRoles(username);
        Set<String> permissions = loginService.findPermission(username);
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }


    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        Object principal = authcToken.getPrincipal();
        System.out.println(loginService);

        User user = null;
        try{
                user= loginService.findByName((String) principal);
        }
        catch (Exception e){
            System.out.println(e);
        }
        if(user!=null){
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"aa");
            return authenticationInfo;

        }
        else {
            return null;
        }

    }

}

