package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.KitDao;
import org.sangaizhi.blog.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.KitQO;
import org.sangaizhi.blog.entity.vo.KitVO;

/**
 * @Description: KitService 实现类
 * @author: sangaizhi
 * @date: 2017-09-27 22:16:39
 */
@Service
public class KitServiceImpl implements KitService {

    @Autowired
    private KitDao kitDao;

    @Override
    @Transactional(readOnly = true)
    public KitVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return kitDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public KitVO getByCondition(KitQO qo) {
        if (qo == null) {
            return null;
        }
        return kitDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KitVO> queryList(KitQO qo) {
        if (qo == null) {
            return null;
        }
        return kitDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(KitQO qo) {
        if (qo == null) {
            return 0;
        }
        return kitDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<KitVO> queryPage(KitQO qo) {
        if (qo == null) {
            return null;
        }
        return kitDao.queryPage(qo); 
    }

    @Override
    public void save(KitVO vo) {
        if (vo == null) {
            return;
        }
        kitDao.save(vo);
    }

    @Override
    public void saveBatch(List<KitVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        kitDao.saveBatch(voList);
    }

    @Override
    public void updateById(KitVO vo) {
        if (vo == null) {
            return;
        }
        kitDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        kitDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        kitDao.deleteBatchByIds(ids);
    }
}
