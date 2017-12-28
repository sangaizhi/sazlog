package org.sangaizhi.blog.sso.service;

import org.sangaizhi.blog.entity.vo.AdminVO;

/**
 * created by sangaizhi on 2017/9/8.
 */
public interface SSOAdminService {

    AdminVO getByToken(String token);
}
