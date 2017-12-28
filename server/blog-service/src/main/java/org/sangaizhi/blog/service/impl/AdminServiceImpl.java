package org.sangaizhi.blog.service.impl;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sangaizhi.blog.entity.qo.AdminQO;
import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.blog.service.AdminService;
import org.sangaizhi.blog.dao.AdminDao;

/**
 * @Description: AdminService 实现类
 * @author: sangaizhi
 * @date: 2017-09-08 23:12:20
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public AdminVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return adminDao.getById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public AdminVO getByCondition(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.getByCondition(qo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryList(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryList(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count(AdminQO qo) {
        if (qo == null) {
            return 0;
        }
        return adminDao.count(qo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminVO> queryPage(AdminQO qo) {
        if (qo == null) {
            return null;
        }
        return adminDao.queryPage(qo); 
    }

    @Override
    public void save(AdminVO vo) {
        if (vo == null) {
            return;
        }
        adminDao.save(vo);
    }

    @Override
    public void saveBatch(List<AdminVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        adminDao.saveBatch(voList);
    }

    @Override
    public void updateById(AdminVO vo) {
        if (vo == null) {
            return;
        }
        adminDao.updateById(vo);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        adminDao.deleteById(id);
    }

    @Override
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        adminDao.deleteBatchByIds(ids);
    }

    @Override
    public AdminVO getByAccountAndPassword(String adminAccount, String password) {
        if(StringUtils.isBlank(adminAccount) || StringUtils.isBlank(password)){
            return null;
        }
        AdminVO adminVO = adminDao.getByAccountAndPassword(adminAccount, password);
        if(null != adminVO){
            adminVO.setPassword(null);
        }
        return adminVO;
    }
}
