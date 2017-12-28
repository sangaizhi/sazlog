package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.ArticleDetailVO;
import org.sangaizhi.blog.entity.qo.ArticleDetailQO;

/**
 * @Description: ArticleDetailService
 * @author: sangaizhi
 * @date: 2017-08-22 23:20:33
 */
public interface ArticleDetailService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return ArticleDetailVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    ArticleDetailVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo ArticleDetailQO查询对象
     * @return ArticleDetailVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    ArticleDetailVO getByCondition(ArticleDetailQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo ArticleDetailQO查询对象
     * @return List<ArticleDetailVO> ArticleDetailVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    List<ArticleDetailVO> queryList(ArticleDetailQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo ArticleDetailQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    long count(ArticleDetailQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo ArticleDetailQO查询对象
     * @return List<ArticleDetailVO> ArticleDetailVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    List<ArticleDetailVO> queryPage(ArticleDetailQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ArticleDetailVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    void save(ArticleDetailVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ArticleDetailVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    void saveBatch(List<ArticleDetailVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ArticleDetailVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    void updateById(ArticleDetailVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ArticleDetailVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ArticleDetailVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:20:33
     */
    void deleteBatchByIds(List<Long> ids);
}
