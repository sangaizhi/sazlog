package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.CategoryDao;
import org.sangaizhi.blog.entity.qo.CategoryQO;
import org.sangaizhi.blog.entity.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.service.CategoryService;

/**
 * @Description: CategoryService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:18:30
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public CategoryVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return categoryDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CategoryVO getByCondition(CategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return categoryDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryVO> queryList(CategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return categoryDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(CategoryQO qo) {
        if (qo == null) {
            return 0;
        }
        return categoryDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CategoryVO> queryPage(CategoryQO qo) {
        if (qo == null) {
            return null;
        }
        return categoryDao.queryPage(qo);
    }

    @Override
    public void save(CategoryVO vo) {
        if (vo == null) {
            return;
        }
        categoryDao.save(vo);
    }

    @Override
    public void saveBatch(List<CategoryVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        categoryDao.saveBatch(voList);
    }

    @Override
    public void updateById(CategoryVO vo) {
        if (vo == null) {
            return;
        }
        categoryDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        categoryDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        categoryDao.deleteBatchByIds(ids);
    }
}
