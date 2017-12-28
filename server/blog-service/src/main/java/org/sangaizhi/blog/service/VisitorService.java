package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.VisitorVO;
import org.sangaizhi.blog.entity.qo.VisitorQO;

/**
 * @Description: VisitorService
 * @author: sangaizhi
 * @date: 2017-08-22 23:23:10
 */
public interface VisitorService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return VisitorVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    VisitorVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo VisitorQO查询对象
     * @return VisitorVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    VisitorVO getByCondition(VisitorQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo VisitorQO查询对象
     * @return List<VisitorVO> VisitorVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    List<VisitorVO> queryList(VisitorQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo VisitorQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    long count(VisitorQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo VisitorQO查询对象
     * @return List<VisitorVO> VisitorVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    List<VisitorVO> queryPage(VisitorQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo VisitorVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    void save(VisitorVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList VisitorVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    void saveBatch(List<VisitorVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo VisitorVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    void updateById(VisitorVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id VisitorVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids VisitorVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:23:10
     */
    void deleteBatchByIds(List<Long> ids);
}
