package org.sangaizhi.blog.sso.service;

import org.sangaizhi.common.constant.ResponseResult;

/**
 * created by sangaizhi on 2017/9/8.
 */
public interface AdminLoginService {
    /**
     * 登录
     * @param adminAccount
     * @param password
     * @return
     */
    ResponseResult login(String adminAccount, String password);

    /**
     * 退出登录
     * @param token
     * @return
     */
    ResponseResult logout(String token);
}
