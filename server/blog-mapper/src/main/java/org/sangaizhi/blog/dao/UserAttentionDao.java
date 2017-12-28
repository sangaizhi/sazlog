package org.sangaizhi.blog.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.sangaizhi.blog.entity.qo.UserAttentionQO;
import org.sangaizhi.blog.entity.vo.UserAttentionVO;

/**
 * @Description: UserAttentionDao
 * @author: sangaizhi
 * @date: 2017-08-22 23:03:14
 */
@Repository
public interface UserAttentionDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return UserAttentionVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    UserAttentionVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo UserAttentionQO查询对象
     * @return UserAttentionVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    UserAttentionVO getByCondition(UserAttentionQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo UserAttentionQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    long count(UserAttentionQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo UserAttentionQO查询对象
     * @return List<UserAttentionVO> UserAttentionVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    List<UserAttentionVO> queryList(UserAttentionQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo UserAttentionQO查询对象
     * @return List<UserAttentionVO> UserAttentionVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    List<UserAttentionVO> queryPage(UserAttentionQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo UserAttentionVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    void save(UserAttentionVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList UserAttentionVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    void saveBatch(List<UserAttentionVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo UserAttentionVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    void updateById(UserAttentionVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id UserAttentionVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids UserAttentionVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:03:14
     */
    void deleteBatchByIds(List<Long> ids);
}
