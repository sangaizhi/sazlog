package org.sangaizhi.blog.sso.controller;

import org.sangaizhi.blog.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sangaizhi
 * @date 2017/8/26
 */
@Controller
public class PageController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/loginPage")
    public String login(){
        return "login";
    }
}
