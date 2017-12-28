package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.service.UserService;
import org.sangaizhi.blog.entity.qo.UserQO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.dao.UserDao;

/**
 * @Description: UserService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 22:56:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return userDao.getById(id);
    }

    @Override
    public UserVO getUserByAccountAndPassword(String account, String password) {
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return null;
        }
        return userDao.getUserByAccountAndPassword(account, password);
    }

    @Override
    @Transactional(readOnly = true)
    public UserVO getByCondition(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryList(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(UserQO qo) {
        if (qo == null) {
            return 0;
        }
        return userDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<UserVO> queryPage(UserQO qo) {
        if (qo == null) {
            return null;
        }
        return userDao.queryPage(qo); 
    }

    @Override
    public void save(UserVO vo) {
        if (vo == null) {
            return;
        }
        userDao.save(vo);
    }

    @Override
    public void saveBatch(List<UserVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        userDao.saveBatch(voList);
    }

    @Override
    public void updateById(UserVO vo) {
        if (vo == null) {
            return;
        }
        userDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        userDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        userDao.deleteBatchByIds(ids);
    }
}
