package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.KitVO;
import org.sangaizhi.blog.entity.qo.KitQO;

/**
 * @Description: KitService
 * @author: sangaizhi
 * @date: 2017-09-27 22:16:39
 */
public interface KitService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return KitVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    KitVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo KitQO查询对象
     * @return KitVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    KitVO getByCondition(KitQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo KitQO查询对象
     * @return List<KitVO> KitVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    List<KitVO> queryList(KitQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo KitQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    long count(KitQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo KitQO查询对象
     * @return List<KitVO> KitVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    List<KitVO> queryPage(KitQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo KitVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    void save(KitVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList KitVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    void saveBatch(List<KitVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo KitVO对象
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    void updateById(KitVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id KitVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids KitVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-27 22:16:39
     */
    void deleteBatchByIds(List<Long> ids);
}
