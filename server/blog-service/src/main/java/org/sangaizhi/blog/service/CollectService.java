package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.CollectVO;
import org.sangaizhi.blog.entity.qo.CollectQO;

/**
 * @Description: CollectService
 * @author: sangaizhi
 * @date: 2017-08-22 23:05:13
 */
public interface CollectService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return CollectVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    CollectVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo CollectQO查询对象
     * @return CollectVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    CollectVO getByCondition(CollectQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo CollectQO查询对象
     * @return List<CollectVO> CollectVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    List<CollectVO> queryList(CollectQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo CollectQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    long count(CollectQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo CollectQO查询对象
     * @return List<CollectVO> CollectVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    List<CollectVO> queryPage(CollectQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo CollectVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    void save(CollectVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList CollectVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    void saveBatch(List<CollectVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo CollectVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    void updateById(CollectVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id CollectVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids CollectVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:05:13
     */
    void deleteBatchByIds(List<Long> ids);
}
