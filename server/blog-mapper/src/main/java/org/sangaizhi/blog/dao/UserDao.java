package org.sangaizhi.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sangaizhi.blog.entity.qo.UserQO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @Description: UserDao
 * @author: sangaizhi
 * @date: 2017-08-22 22:56:30
 */
@Repository
public interface UserDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    UserVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo UserQO查询对象
     * @return UserVO 对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    UserVO getByCondition(UserQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo UserQO查询对象
     * @return long 记录条数
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    long count(UserQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    List<UserVO> queryList(UserQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo UserQO查询对象
     * @return List<UserVO> UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    List<UserVO> queryPage(UserQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo UserVO对象信息
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    void save(UserVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList UserVO对象列表
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    void saveBatch(List<UserVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo UserVO对象
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    void updateById(UserVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id UserVO对象Id
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids UserVO对象Id集合
     * @author: sangaizhi
     * @date: 2017-08-22 22:56:30
     */
    void deleteBatchByIds(List<Long> ids);

    /**
     * 根据账号密码查询用户
     * @param account 账号
     * @param password 密码
     * @return
     */
    UserVO getUserByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}
