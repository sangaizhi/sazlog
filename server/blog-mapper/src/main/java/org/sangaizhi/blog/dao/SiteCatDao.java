package org.sangaizhi.blog.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.sangaizhi.blog.entity.qo.SiteCatQO;
import org.sangaizhi.blog.entity.vo.SiteCatVO;

/**
 * @Description: SiteCatDao
 * @author: sangaizhi
 * @date: 2017-09-27 22:20:00
 */
@Repository
public interface SiteCatDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return SiteCatVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    SiteCatVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo SiteCatQO查询对象
     * @return SiteCatVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    SiteCatVO getByCondition(SiteCatQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo SiteCatQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    long count(SiteCatQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo SiteCatQO查询对象
     * @return List<SiteCatVO> SiteCatVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    List<SiteCatVO> queryList(SiteCatQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo SiteCatQO查询对象
     * @return List<SiteCatVO> SiteCatVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    List<SiteCatVO> queryPage(SiteCatQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo SiteCatVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    void save(SiteCatVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList SiteCatVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    void saveBatch(List<SiteCatVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo SiteCatVO对象
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    void updateById(SiteCatVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id SiteCatVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids SiteCatVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-27 22:20:00
     */
    void deleteBatchByIds(List<Long> ids);
}
