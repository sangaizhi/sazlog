package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.sangaizhi.blog.dao.CommentDao;
import org.sangaizhi.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.CommentQO;
import org.sangaizhi.blog.entity.vo.CommentVO;

/**
 * @Description: CommentService 实现类
 * @author: sangaizhi
 * @date: 2017-09-26 23:18:51
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    @Transactional(readOnly = true)
    public CommentVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return commentDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public CommentVO getByCondition(CommentQO qo) {
        if (qo == null) {
            return null;
        }
        return commentDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentVO> queryList(CommentQO qo) {
        if (qo == null) {
            return null;
        }
        return commentDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(CommentQO qo) {
        if (qo == null) {
            return 0;
        }
        return commentDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CommentVO> queryPage(CommentQO qo) {
        if (qo == null) {
            return null;
        }
        return commentDao.queryPage(qo); 
    }

    @Override
    public void save(CommentVO vo) {
        if (vo == null) {
            return;
        }
        commentDao.save(vo);
    }

    @Override
    public void saveBatch(List<CommentVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        commentDao.saveBatch(voList);
    }

    @Override
    public void updateById(CommentVO vo) {
        if (vo == null) {
            return;
        }
        commentDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        commentDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        commentDao.deleteBatchByIds(ids);
    }
}
