package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Description: KitBoxVO 值对象
 * @author: sangaizhi
 * @date: 2017-09-27 22:14:27
 */
public class KitBoxVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 工具箱名称 
     */
    private String name;
    
    /**
     * 创建时间 
     */
    private Date createTime;
    
    /**
     * 修改时间 
     */
    private Date modifyTime;

    private List<KitVO> kitList;

    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public List<KitVO> getKitList() {
        return kitList;
    }

    public void setKitList(List<KitVO> kitList) {
        this.kitList = kitList;
    }
}

