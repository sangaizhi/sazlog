package org.sangaizhi.blog.sso.service.impl;

import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.sso.service.SSOUserService;
import org.sangaizhi.blog.sso.util.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/8/26
 */
@Service
public class SSOUserServiceImpl implements SSOUserService {

    @Autowired
    private RedisCache redisCache;
    @Override
    public UserVO getUserByToken(String token) {
        return redisCache.getCache(token, UserVO.class);
    }
}
