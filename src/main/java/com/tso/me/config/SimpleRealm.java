package com.tso.me.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author lzk
 * @date 2019/1/9
 */
@Component
public class SimpleRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usrPwdToken = (UsernamePasswordToken) token;
        String name = usrPwdToken.getUsername();
        String password = String.valueOf(usrPwdToken.getPassword());

        //研究结果，只要把真实密码放入下面的info类中，shiro会自动校验UserNamePasswordToken中的密码与info中的密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name,"root",getName());

        return info;
    }
}
