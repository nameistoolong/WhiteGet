package com.whiteget.system.controller;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.whiteget.framework.shiro.util.ShiroUtils.getSubject;

/**
 * 登陆接口
 *
 * @author fjc
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    @PostMapping("/login")
    public void login(String username, String passwd){
        UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
        Subject subject = getSubject();
        subject.login(token);
    }



    @GetMapping("/unauth")
    public String unauth() {
        return "error/unauth";
    }
}
