package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.CollectQO;
import org.sangaizhi.blog.entity.vo.CollectVO;
import org.sangaizhi.blog.service.CollectService;
import org.sangaizhi.blog.dao.CollectDao;

/**
 * @Description: CollectService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:05:13
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Override
    @Transactional(readOnly = true)
    public CollectVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return collectDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CollectVO getByCondition(CollectQO qo) {
        if (qo == null) {
            return null;
        }
        return collectDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CollectVO> queryList(CollectQO qo) {
        if (qo == null) {
            return null;
        }
        return collectDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(CollectQO qo) {
        if (qo == null) {
            return 0;
        }
        return collectDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CollectVO> queryPage(CollectQO qo) {
        if (qo == null) {
            return null;
        }
        return collectDao.queryPage(qo); 
    }

    @Override
    public void save(CollectVO vo) {
        if (vo == null) {
            return;
        }
        collectDao.save(vo);
    }

    @Override
    public void saveBatch(List<CollectVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        collectDao.saveBatch(voList);
    }

    @Override
    public void updateById(CollectVO vo) {
        if (vo == null) {
            return;
        }
        collectDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        collectDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        collectDao.deleteBatchByIds(ids);
    }
}
