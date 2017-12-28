package org.sangaizhi.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.sangaizhi.blog.entity.qo.AdminQO;
import org.sangaizhi.blog.entity.vo.AdminVO;

/**
 * @Description: AdminDao
 * @author: sangaizhi
 * @date: 2017-09-08 23:12:20
 */
@Repository
public interface AdminDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    AdminVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo AdminQO查询对象
     * @return AdminVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    AdminVO getByCondition(AdminQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo AdminQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    long count(AdminQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    List<AdminVO> queryList(AdminQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo AdminQO查询对象
     * @return List<AdminVO> AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    List<AdminVO> queryPage(AdminQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo AdminVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    void save(AdminVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList AdminVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    void saveBatch(List<AdminVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo AdminVO对象
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    void updateById(AdminVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id AdminVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids AdminVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-08 23:12:20
     */
    void deleteBatchByIds(List<Long> ids);

    /**
     * 根据密码和账号查询管理员信息
     * @param adminAccount 账号
     * @param password 密码（已加密）
     * @return
     */
    AdminVO getByAccountAndPassword(@Param("account") String adminAccount, @Param("password") String password);
}
