package org.sangaizhi.blog.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.service.UserService;
import org.sangaizhi.blog.sso.service.LoginService;
import org.sangaizhi.blog.sso.util.cache.RedisCache;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.dict.UserStatusDict;
import org.sangaizhi.common.util.EncryptUtil;
import org.sangaizhi.common.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author sangaizhi
 * @date 2017/8/24
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;


    @Value("${password.encrypt.times}")
    private Integer passwordEncryptTimes;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    private Long SSO_SESSION_EXPIRE;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(String account, String password) {
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return ResponseResult.fail("账号和密码不能为空");
        }
        if(null == passwordEncryptTimes){
            passwordEncryptTimes = 2;
        }
        password = EncryptUtil.md5Hex(password, passwordEncryptTimes);
        UserVO userVO = userService.getUserByAccountAndPassword(account, password);
        if(null == userVO){
            return ResponseResult.fail("账号或密码错误");
        }
        if(Objects.equals(userVO.getStatus(), UserStatusDict.INIT.getValue())){
            return ResponseResult.fail("账号未激活");
        }
        if(Objects.equals(userVO.getStatus(), UserStatusDict.DISABLED.getValue())){
            return ResponseResult.fail("账号被禁用");
        }
        if(Objects.equals(userVO.getStatus(), UserStatusDict.LOCKED.getValue())){
            return ResponseResult.fail("账号被锁定");
        }
        // 生成token 并缓存
        String token = REDIS_USER_SESSION_KEY + ":" + UUIDUtil.generateAllString(32);
        //设置session的过期时间
        redisCache.putCacheWithExpireTime(token, userVO, SSO_SESSION_EXPIRE);
        return ResponseResult.ok("登录成功", token);
    }
}
