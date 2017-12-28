package org.sangaizhi.blog.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.sangaizhi.blog.entity.qo.CommentQO;
import org.sangaizhi.blog.entity.vo.CommentVO;

/**
 * @Description: CommentDao
 * @author: sangaizhi
 * @date: 2017-09-26 23:18:51
 */
@Repository
public interface CommentDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return CommentVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    CommentVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo CommentQO查询对象
     * @return CommentVO 对象信息
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    CommentVO getByCondition(CommentQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo CommentQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    long count(CommentQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo CommentQO查询对象
     * @return List<CommentVO> CommentVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    List<CommentVO> queryList(CommentQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo CommentQO查询对象
     * @return List<CommentVO> CommentVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    List<CommentVO> queryPage(CommentQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo CommentVO对象信息
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    void save(CommentVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList CommentVO对象列表
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    void saveBatch(List<CommentVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo CommentVO对象
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    void updateById(CommentVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id CommentVO对象Id
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids CommentVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-09-26 23:18:51
     */
    void deleteBatchByIds(List<Long> ids);
}
