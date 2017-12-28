package org.sangaizhi.blog.sso.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.service.AdminService;
import org.sangaizhi.blog.sso.service.AdminLoginService;
import org.sangaizhi.blog.sso.util.cache.RedisCache;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.util.EncryptUtil;
import org.sangaizhi.common.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/9/8
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {


    /**
     * 密碼加密次數
     */
    @Value("${password.encrypt.times}")
    private Integer passwordEncryptTimes;

    /**
     * redis 缓存用户的token
     */
    @Value("${REDIS_ADMIN_SESSION_KEY}")
    private String REDIS_ADMIN_SESSION_KEY;


    /**
     * redis  缓存过期时间
     */
    @Value("${SSO_SESSION_EXPIRE}")
    private Long SSO_SESSION_EXPIRE;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(String adminAccount, String password) {
        if(StringUtils.isBlank(adminAccount) || StringUtils.isBlank(password)){
            return ResponseResult.fail("账号和密码不能为空");
        }
        if(null == passwordEncryptTimes){
            passwordEncryptTimes = 2;
        }
        password = EncryptUtil.md5Hex(password, passwordEncryptTimes);
        AdminVO admin = adminService.getByAccountAndPassword(adminAccount, password);
        if(null == admin){
            return ResponseResult.fail("账号或密码错误");
        }
        // 生成token 并缓存
        String token = REDIS_ADMIN_SESSION_KEY + ":" + UUIDUtil.generateAllString(32);
        //设置session的过期时间
        redisCache.putCacheWithExpireTime(token, admin, SSO_SESSION_EXPIRE);
        return ResponseResult.ok("登录成功", token);
    }

    @Override
    public ResponseResult logout(String token) {
        redisCache.deleteCache(token);
        return ResponseResult.ok("退出登录成功");
    }
}
