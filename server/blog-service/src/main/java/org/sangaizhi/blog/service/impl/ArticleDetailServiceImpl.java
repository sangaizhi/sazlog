package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.ArticleDetailDao;
import org.sangaizhi.blog.entity.qo.ArticleDetailQO;
import org.sangaizhi.blog.entity.vo.ArticleDetailVO;
import org.sangaizhi.blog.service.ArticleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: ArticleDetailService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:20:33
 */
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {

    @Autowired
    private ArticleDetailDao articleDetailDao;

    @Override
    @Transactional(readOnly = true)
    public ArticleDetailVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return articleDetailDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArticleDetailVO getByCondition(ArticleDetailQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDetailDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleDetailVO> queryList(ArticleDetailQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDetailDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(ArticleDetailQO qo) {
        if (qo == null) {
            return 0;
        }
        return articleDetailDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ArticleDetailVO> queryPage(ArticleDetailQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDetailDao.queryPage(qo); 
    }

    @Override
    public void save(ArticleDetailVO vo) {
        if (vo == null) {
            return;
        }
        articleDetailDao.save(vo);
    }

    @Override
    public void saveBatch(List<ArticleDetailVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        articleDetailDao.saveBatch(voList);
    }

    @Override
    public void updateById(ArticleDetailVO vo) {
        if (vo == null) {
            return;
        }
        articleDetailDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        articleDetailDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        articleDetailDao.deleteBatchByIds(ids);
    }
}
