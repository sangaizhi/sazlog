package org.sangaizhi.blog.admin.service;

import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.common.constant.ResponseResult;

/**
 * created by sangaizhi on 2017/9/24.
 */
public interface UserService {

    /**
     * 更新用户状态
     * @param id 用户id
     * @param status 目标状态
     */
    void updateUserStatus(Long id, Short status);

    void saveOrUpdate(UserVO user);

    ResponseResult save(UserVO user);

    ResponseResult update(UserVO user);
}
