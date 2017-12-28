package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.ArticleDao;
import org.sangaizhi.blog.entity.qo.ArticleQO;
import org.sangaizhi.blog.entity.vo.ArticleVO;
import org.sangaizhi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: ArticleService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:19:25
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    @Transactional(readOnly = true)
    public ArticleVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return articleDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArticleVO getByCondition(ArticleQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleVO> queryList(ArticleQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(ArticleQO qo) {
        if (qo == null) {
            return 0;
        }
        return articleDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ArticleVO> queryPage(ArticleQO qo) {
        if (qo == null) {
            return null;
        }
        return articleDao.queryPage(qo); 
    }

    @Override
    public void save(ArticleVO vo) {
        if (vo == null) {
            return;
        }
        articleDao.save(vo);
    }

    @Override
    public void saveBatch(List<ArticleVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        articleDao.saveBatch(voList);
    }

    @Override
    public void updateById(ArticleVO vo) {
        if (vo == null) {
            return;
        }
        articleDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        articleDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        articleDao.deleteBatchByIds(ids);
    }
}
