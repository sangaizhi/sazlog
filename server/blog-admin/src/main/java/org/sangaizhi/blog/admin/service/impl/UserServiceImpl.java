package org.sangaizhi.blog.admin.service.impl;

import org.sangaizhi.blog.admin.service.UserService;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.common.constant.LogConstants;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.dict.UserStatusDict;
import org.sangaizhi.common.exception.BusinessRuntimeException;
import org.sangaizhi.common.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sangaizhi
 * @date 2017/9/24
 */
@Service("adminUserService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private org.sangaizhi.blog.service.UserService  userService;

    @Override
    public void updateUserStatus(Long id, Short status) {
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS_START, "更新用户状态", JacksonUtil.toJson(id, status));
        UserVO userVO = userService.getById(id);
        if(null == id){
            throw new BusinessRuntimeException("","没有找到对应用户");
        }
        UserVO temp = new UserVO();
        temp.setId(id);
        temp.setStatus(status);
        userService.updateById(temp);
    }

    @Override
    public void saveOrUpdate(UserVO user) {
        if(null == user.getId()){
            this.save(user);
        }else{
            this.update(user);
        }
    }

    /**
     * 保存用户
     * @param user
     */
    @Override
    public ResponseResult save(UserVO user) {
        logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "新增用户", user);
        user.setStatus(UserStatusDict.INIT.getValue());
        user.setCreateTime(new Date());
        userService.save(user);
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult update(UserVO user) {
        if(null == user.getId()){
            throw new BusinessRuntimeException("", "更新用户Id为空");
        }
        user.setModifyTime(new Date());
        userService.updateById(user);
        return ResponseResult.ok();
    }

}
