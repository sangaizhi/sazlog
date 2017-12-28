package org.sangaizhi.blog.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.sso.service.AdminLoginService;
import org.sangaizhi.blog.sso.service.SSOAdminService;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.constant.SystemConstant;
import org.sangaizhi.common.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @date 2017/9/8
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private SSOAdminService ssoAdminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult login(String account, String password, String redirectUrl, HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return ResponseResult.fail("账号或密码不能为空");
        }
        ResponseResult responseResult =  adminLoginService.login(account, password);
        return responseResult;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult logout(@RequestParam() String token){
        if(StringUtils.isBlank(token)){
            return ResponseResult.fail("退出登录失败");
        }
        return adminLoginService.logout(token);
    }

    @RequestMapping(value = "/getAdminByToken", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult getAdminByToken(@RequestParam String token,HttpServletRequest request){
        AdminVO admin = ssoAdminService.getByToken(token);
        if(null == admin){
            return ResponseResult.fail("获取管理员信息失败");
        }
        return ResponseResult.ok("获取管理员信息成功", admin);
    }

}
