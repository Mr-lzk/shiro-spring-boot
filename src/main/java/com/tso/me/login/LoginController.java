package com.tso.me.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzk
 * @date 2019/1/9
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String login(String name, String pwd) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,pwd);
        subject.login(token);

        return "pass";
    }
}
