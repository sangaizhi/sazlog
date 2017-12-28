package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.vo.ArticleVO;
import org.sangaizhi.blog.entity.qo.ArticleQO;

/**
 * @Description: ArticleService
 * @author: sangaizhi
 * @date: 2017-08-22 23:19:25
 */
public interface ArticleService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return ArticleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    ArticleVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo ArticleQO查询对象
     * @return ArticleVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    ArticleVO getByCondition(ArticleQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo ArticleQO查询对象
     * @return List<ArticleVO> ArticleVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    List<ArticleVO> queryList(ArticleQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo ArticleQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    long count(ArticleQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo ArticleQO查询对象
     * @return List<ArticleVO> ArticleVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    List<ArticleVO> queryPage(ArticleQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ArticleVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    void save(ArticleVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ArticleVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    void saveBatch(List<ArticleVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ArticleVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    void updateById(ArticleVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ArticleVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ArticleVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:19:25
     */
    void deleteBatchByIds(List<Long> ids);
}
