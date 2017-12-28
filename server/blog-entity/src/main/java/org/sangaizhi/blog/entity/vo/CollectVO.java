package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: CollectVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:05:13
 */
public class CollectVO implements Serializable {

    
    /**
     * 主鍵 
     */
    private Long id;
    
    /**
     * 收藏人 
     */
    private Long userId;
    
    /**
     * 收藏标题 
     */
    private String title;
    
    /**
     * 链接地址 
     */
    private String link;
    
    /**
     * 描述 
     */
    private String remark;
    
    /**
     * 创建时间 
     */
    private Date createTime;
    
    /**
     * 修改时间 
     */
    private Date modifyTime;

    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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
}

