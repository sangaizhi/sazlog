package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.SiteCatDao;
import org.sangaizhi.blog.service.SiteCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.SiteCatQO;
import org.sangaizhi.blog.entity.vo.SiteCatVO;

/**
 * @Description: SiteCatService 实现类
 * @author: sangaizhi
 * @date: 2017-09-27 22:20:00
 */
@Service
public class SiteCatServiceImpl implements SiteCatService {

    @Autowired
    private SiteCatDao siteCatDao;

    @Override
    @Transactional(readOnly = true)
    public SiteCatVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return siteCatDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public SiteCatVO getByCondition(SiteCatQO qo) {
        if (qo == null) {
            return null;
        }
        return siteCatDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiteCatVO> queryList(SiteCatQO qo) {
        if (qo == null) {
            return null;
        }
        return siteCatDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(SiteCatQO qo) {
        if (qo == null) {
            return 0;
        }
        return siteCatDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<SiteCatVO> queryPage(SiteCatQO qo) {
        if (qo == null) {
            return null;
        }
        return siteCatDao.queryPage(qo); 
    }

    @Override
    public void save(SiteCatVO vo) {
        if (vo == null) {
            return;
        }
        siteCatDao.save(vo);
    }

    @Override
    public void saveBatch(List<SiteCatVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        siteCatDao.saveBatch(voList);
    }

    @Override
    public void updateById(SiteCatVO vo) {
        if (vo == null) {
            return;
        }
        siteCatDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        siteCatDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        siteCatDao.deleteBatchByIds(ids);
    }
}
