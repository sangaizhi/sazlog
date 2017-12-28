package org.sangaizhi.blog.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.sangaizhi.blog.entity.qo.SiteQO;
import org.sangaizhi.blog.entity.vo.SiteVO;

/**
 * @Description: SiteDao
 * @author: sangaizhi
 * @date: 2017-09-27 22:22:12
 */
@Repository
public interface SiteDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SiteVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    SiteVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo SiteQO查询对象
     * @return SiteVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    SiteVO getByCondition(SiteQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo SiteQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    long count(SiteQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo SiteQO查询对象
     * @return List<SiteVO> SiteVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    List<SiteVO> queryList(SiteQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo SiteQO查询对象
     * @return List<SiteVO> SiteVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    List<SiteVO> queryPage(SiteQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo SiteVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    void save(SiteVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList SiteVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    void saveBatch(List<SiteVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo SiteVO对象
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    void updateById(SiteVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SiteVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SiteVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-27 22:22:12
     */
    void deleteBatchByIds(List<Long> ids);
}
