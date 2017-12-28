package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.ReplyVO;
import org.sangaizhi.blog.entity.qo.ReplyQO;

/**
 * @Description: ReplyService
 * @author: sangaizhi
 * @date: 2017-08-22 23:10:44
 */
public interface ReplyService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return ReplyVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    ReplyVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo ReplyQO查询对象
     * @return ReplyVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    ReplyVO getByCondition(ReplyQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo ReplyQO查询对象
     * @return List<ReplyVO> ReplyVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    List<ReplyVO> queryList(ReplyQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo ReplyQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    long count(ReplyQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo ReplyQO查询对象
     * @return List<ReplyVO> ReplyVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    List<ReplyVO> queryPage(ReplyQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ReplyVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    void save(ReplyVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ReplyVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    void saveBatch(List<ReplyVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ReplyVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    void updateById(ReplyVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ReplyVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ReplyVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:10:44
     */
    void deleteBatchByIds(List<Long> ids);
}
