package org.sangaizhi.blog.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.sso.service.LoginService;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.constant.SystemConstant;
import org.sangaizhi.common.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @date 2017/8/26
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult login(String account, String password, String redirectUrl, HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return ResponseResult.fail("账号或密码不能为空");
        }
        ResponseResult responseResult = loginService.login(account, password);
        if(!responseResult.getStatus()){
            return responseResult;
        }
        String token = (String) responseResult.getData();
        CookieUtils.setCookie(request, response, SystemConstant.USER_TOKEN_COOKIE_KEY, token);
        return responseResult;
    }

}
