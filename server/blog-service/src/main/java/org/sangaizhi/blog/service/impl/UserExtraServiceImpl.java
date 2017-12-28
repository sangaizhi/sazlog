package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.UserExtraDao;
import org.sangaizhi.blog.entity.qo.UserExtraQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.vo.UserExtraVO;
import org.sangaizhi.blog.service.UserExtraService;

/**
 * @Description: UserExtraService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:00:39
 */
@Service
public class UserExtraServiceImpl implements UserExtraService {

    @Autowired
    private UserExtraDao userExtraDao;

    @Override
    @Transactional(readOnly = true)
    public UserExtraVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return userExtraDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserExtraVO getByCondition(UserExtraQO qo) {
        if (qo == null) {
            return null;
        }
        return userExtraDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserExtraVO> queryList(UserExtraQO qo) {
        if (qo == null) {
            return null;
        }
        return userExtraDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(UserExtraQO qo) {
        if (qo == null) {
            return 0;
        }
        return userExtraDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<UserExtraVO> queryPage(UserExtraQO qo) {
        if (qo == null) {
            return null;
        }
        return userExtraDao.queryPage(qo); 
    }

    @Override
    public void save(UserExtraVO vo) {
        if (vo == null) {
            return;
        }
        userExtraDao.save(vo);
    }

    @Override
    public void saveBatch(List<UserExtraVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        userExtraDao.saveBatch(voList);
    }

    @Override
    public void updateById(UserExtraVO vo) {
        if (vo == null) {
            return;
        }
        userExtraDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        userExtraDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        userExtraDao.deleteBatchByIds(ids);
    }
}
