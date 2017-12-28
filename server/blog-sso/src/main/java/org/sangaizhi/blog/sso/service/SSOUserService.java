package org.sangaizhi.blog.sso.service;

import org.sangaizhi.blog.entity.vo.UserVO;

/**
 * created by sangaizhi on 2017/8/26.
 */
public interface SSOUserService {

    /**
     * 根据token 从redis 中获取用户信息
     * @param token
     * @return
     */
    UserVO getUserByToken(String token);
}
