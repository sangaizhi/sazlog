package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.KitBoxDao;
import org.sangaizhi.blog.service.KitBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.KitBoxQO;
import org.sangaizhi.blog.entity.vo.KitBoxVO;

/**
 * @Description: KitBoxService 实现类
 * @author: sangaizhi
 * @date: 2017-09-27 22:14:27
 */
@Service
public class KitBoxServiceImpl implements KitBoxService {

    @Autowired
    private KitBoxDao kitBoxDao;

    @Override
    @Transactional(readOnly = true)
    public KitBoxVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return kitBoxDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public KitBoxVO getByCondition(KitBoxQO qo) {
        if (qo == null) {
            return null;
        }
        return kitBoxDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KitBoxVO> queryList(KitBoxQO qo) {
        if (qo == null) {
            return null;
        }
        return kitBoxDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(KitBoxQO qo) {
        if (qo == null) {
            return 0;
        }
        return kitBoxDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<KitBoxVO> queryPage(KitBoxQO qo) {
        if (qo == null) {
            return null;
        }
        return kitBoxDao.queryPage(qo); 
    }

    @Override
    public void save(KitBoxVO vo) {
        if (vo == null) {
            return;
        }
        kitBoxDao.save(vo);
    }

    @Override
    public void saveBatch(List<KitBoxVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        kitBoxDao.saveBatch(voList);
    }

    @Override
    public void updateById(KitBoxVO vo) {
        if (vo == null) {
            return;
        }
        kitBoxDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        kitBoxDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        kitBoxDao.deleteBatchByIds(ids);
    }
}
