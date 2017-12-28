package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.KitBoxVO;
import org.sangaizhi.blog.entity.qo.KitBoxQO;

/**
 * @Description: KitBoxService
 * @author: sangaizhi
 * @date: 2017-09-27 22:14:27
 */
public interface KitBoxService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return KitBoxVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    KitBoxVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo KitBoxQO查询对象
     * @return KitBoxVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    KitBoxVO getByCondition(KitBoxQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo KitBoxQO查询对象
     * @return List<KitBoxVO> KitBoxVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    List<KitBoxVO> queryList(KitBoxQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo KitBoxQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    long count(KitBoxQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo KitBoxQO查询对象
     * @return List<KitBoxVO> KitBoxVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    List<KitBoxVO> queryPage(KitBoxQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo KitBoxVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    void save(KitBoxVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList KitBoxVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    void saveBatch(List<KitBoxVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo KitBoxVO对象
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    void updateById(KitBoxVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id KitBoxVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids KitBoxVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-27 22:14:27
     */
    void deleteBatchByIds(List<Long> ids);
}
