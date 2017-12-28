package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.UserExtraVO;
import org.sangaizhi.blog.entity.qo.UserExtraQO;

/**
 * @Description: UserExtraService
 * @author: sangaizhi
 * @date: 2017-08-22 23:00:39
 */
public interface UserExtraService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return UserExtraVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    UserExtraVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo UserExtraQO查询对象
     * @return UserExtraVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    UserExtraVO getByCondition(UserExtraQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo UserExtraQO查询对象
     * @return List<UserExtraVO> UserExtraVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    List<UserExtraVO> queryList(UserExtraQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo UserExtraQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    long count(UserExtraQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo UserExtraQO查询对象
     * @return List<UserExtraVO> UserExtraVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    List<UserExtraVO> queryPage(UserExtraQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo UserExtraVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    void save(UserExtraVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList UserExtraVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    void saveBatch(List<UserExtraVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo UserExtraVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    void updateById(UserExtraVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id UserExtraVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids UserExtraVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:00:39
     */
    void deleteBatchByIds(List<Long> ids);
}
