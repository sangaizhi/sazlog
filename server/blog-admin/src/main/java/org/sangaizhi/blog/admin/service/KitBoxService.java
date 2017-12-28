package org.sangaizhi.blog.admin.service;

/**
 * created by sangaizhi on 2017/9/27.
 */
public interface KitBoxService {

    /**
     * 重命名工具箱
     * @param id 工具箱ID
     * @param name 工具箱名称
     */
    void rename(Long id, String name);

    /**
     * 删除工具箱
     * @param id 工具箱Id
     */
    void delete(Long id);

}
