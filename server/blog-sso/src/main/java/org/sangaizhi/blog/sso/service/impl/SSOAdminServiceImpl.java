package org.sangaizhi.blog.sso.service.impl;

import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.sso.service.SSOAdminService;
import org.sangaizhi.blog.sso.util.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/9/8
 */
@Service
public class SSOAdminServiceImpl implements SSOAdminService {

    @Autowired
    private RedisCache redisCache;

    @Override
    public AdminVO getByToken(String token) {
        return redisCache.getCache(token, AdminVO.class);
    }

}
