package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.UserAttentionDao;
import org.sangaizhi.blog.service.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.UserAttentionQO;
import org.sangaizhi.blog.entity.vo.UserAttentionVO;

/**
 * @Description: UserAttentionService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:03:14
 */
@Service
public class UserAttentionServiceImpl implements UserAttentionService {

    @Autowired
    private UserAttentionDao userAttentionDao;

    @Override
    @Transactional(readOnly = true)
    public UserAttentionVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return userAttentionDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserAttentionVO getByCondition(UserAttentionQO qo) {
        if (qo == null) {
            return null;
        }
        return userAttentionDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAttentionVO> queryList(UserAttentionQO qo) {
        if (qo == null) {
            return null;
        }
        return userAttentionDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(UserAttentionQO qo) {
        if (qo == null) {
            return 0;
        }
        return userAttentionDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<UserAttentionVO> queryPage(UserAttentionQO qo) {
        if (qo == null) {
            return null;
        }
        return userAttentionDao.queryPage(qo); 
    }

    @Override
    public void save(UserAttentionVO vo) {
        if (vo == null) {
            return;
        }
        userAttentionDao.save(vo);
    }

    @Override
    public void saveBatch(List<UserAttentionVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        userAttentionDao.saveBatch(voList);
    }

    @Override
    public void updateById(UserAttentionVO vo) {
        if (vo == null) {
            return;
        }
        userAttentionDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        userAttentionDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        userAttentionDao.deleteBatchByIds(ids);
    }
}
