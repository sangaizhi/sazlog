package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.ReplyQO;
import org.sangaizhi.blog.entity.vo.ReplyVO;
import org.sangaizhi.blog.service.ReplyService;
import org.sangaizhi.blog.dao.ReplyDao;

/**
 * @Description: ReplyService 实现类
 * @author: sangaizhi
 * @date: 2017-08-22 23:10:44
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    @Transactional(readOnly = true)
    public ReplyVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return replyDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ReplyVO getByCondition(ReplyQO qo) {
        if (qo == null) {
            return null;
        }
        return replyDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReplyVO> queryList(ReplyQO qo) {
        if (qo == null) {
            return null;
        }
        return replyDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(ReplyQO qo) {
        if (qo == null) {
            return 0;
        }
        return replyDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ReplyVO> queryPage(ReplyQO qo) {
        if (qo == null) {
            return null;
        }
        return replyDao.queryPage(qo); 
    }

    @Override
    public void save(ReplyVO vo) {
        if (vo == null) {
            return;
        }
        replyDao.save(vo);
    }

    @Override
    public void saveBatch(List<ReplyVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        replyDao.saveBatch(voList);
    }

    @Override
    public void updateById(ReplyVO vo) {
        if (vo == null) {
            return;
        }
        replyDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        replyDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        replyDao.deleteBatchByIds(ids);
    }
}
