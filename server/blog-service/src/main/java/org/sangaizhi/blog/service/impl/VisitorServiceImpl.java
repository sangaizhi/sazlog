package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.VisitorDao;
import org.sangaizhi.blog.service.VisitorService;
import org.sangaizhi.blog.entity.qo.VisitorQO;
import org.sangaizhi.blog.entity.vo.VisitorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: VisitorService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:23:10
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    @Override
    @Transactional(readOnly = true)
    public VisitorVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return visitorDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public VisitorVO getByCondition(VisitorQO qo) {
        if (qo == null) {
            return null;
        }
        return visitorDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VisitorVO> queryList(VisitorQO qo) {
        if (qo == null) {
            return null;
        }
        return visitorDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(VisitorQO qo) {
        if (qo == null) {
            return 0;
        }
        return visitorDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<VisitorVO> queryPage(VisitorQO qo) {
        if (qo == null) {
            return null;
        }
        return visitorDao.queryPage(qo); 
    }

    @Override
    public void save(VisitorVO vo) {
        if (vo == null) {
            return;
        }
        visitorDao.save(vo);
    }

    @Override
    public void saveBatch(List<VisitorVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        visitorDao.saveBatch(voList);
    }

    @Override
    public void updateById(VisitorVO vo) {
        if (vo == null) {
            return;
        }
        visitorDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        visitorDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        visitorDao.deleteBatchByIds(ids);
    }
}
