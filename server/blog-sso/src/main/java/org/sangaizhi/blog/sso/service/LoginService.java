package org.sangaizhi.blog.sso.service;

import org.sangaizhi.common.constant.ResponseResult;

/**
 * created by sangaizhi on 2017/8/24.
 */
public interface LoginService {

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    ResponseResult login(String account, String password);
}
