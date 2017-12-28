package org.sangaizhi.blog.sso.controller;

import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.sso.service.SSOUserService;
import org.sangaizhi.common.constant.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sangaizhi
 * @date 2017/8/26
 */
@Controller
public class UserController {

    @Autowired
    private SSOUserService SSOUserService;

    @RequestMapping(value = "/getUserByToken", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult getUserByToken(@RequestParam(required = true) String token){
        UserVO user = SSOUserService.getUserByToken(token);
        if(null == user){
            return ResponseResult.fail("获取用户信息失败");
        }
        return ResponseResult.ok("获取用户信息成功", user);
    }

}
