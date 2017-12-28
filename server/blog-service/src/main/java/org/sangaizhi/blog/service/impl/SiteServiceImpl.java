package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.SiteDao;
import org.sangaizhi.blog.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.SiteQO;
import org.sangaizhi.blog.entity.vo.SiteVO;

/**
 * @Description: SiteService 实现类
 * @author: sangaizhi
 * @date: 2017-09-27 22:22:12
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDao siteDao;

    @Override
    @Transactional(readOnly = true)
    public SiteVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return siteDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public SiteVO getByCondition(SiteQO qo) {
        if (qo == null) {
            return null;
        }
        return siteDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiteVO> queryList(SiteQO qo) {
        if (qo == null) {
            return null;
        }
        return siteDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(SiteQO qo) {
        if (qo == null) {
            return 0;
        }
        return siteDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<SiteVO> queryPage(SiteQO qo) {
        if (qo == null) {
            return null;
        }
        return siteDao.queryPage(qo); 
    }

    @Override
    public void save(SiteVO vo) {
        if (vo == null) {
            return;
        }
        siteDao.save(vo);
    }

    @Override
    public void saveBatch(List<SiteVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        siteDao.saveBatch(voList);
    }

    @Override
    public void updateById(SiteVO vo) {
        if (vo == null) {
            return;
        }
        siteDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        siteDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        siteDao.deleteBatchByIds(ids);
    }
}
