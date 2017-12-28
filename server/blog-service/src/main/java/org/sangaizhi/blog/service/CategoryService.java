package org.sangaizhi.blog.service;

import java.util.List;

import org.sangaizhi.blog.entity.qo.CategoryQO;
import org.sangaizhi.blog.entity.vo.CategoryVO;

/**
 * @Description: CategoryService
 * @author: sangaizhi
 * @date: 2017-08-22 23:18:30
 */
public interface CategoryService {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return CategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    CategoryVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo ArticleTypeQO查询对象
     * @return CategoryVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    CategoryVO getByCondition(CategoryQO qo);
    
    /**
     * 根据条件查询对象列表
     * 
     * @param qo ArticleTypeQO查询对象
     * @return List<CategoryVO> ArticleTypeVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    List<CategoryVO> queryList(CategoryQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo ArticleTypeQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    long count(CategoryQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo ArticleTypeQO查询对象
     * @return List<CategoryVO> ArticleTypeVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    List<CategoryVO> queryPage(CategoryQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ArticleTypeVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    void save(CategoryVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ArticleTypeVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    void saveBatch(List<CategoryVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ArticleTypeVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    void updateById(CategoryVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ArticleTypeVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ArticleTypeVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 23:18:30
     */
    void deleteBatchByIds(List<Long> ids);
}
