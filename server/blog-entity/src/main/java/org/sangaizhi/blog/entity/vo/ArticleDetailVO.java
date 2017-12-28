package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ArticleDetailVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:20:33
 */
public class ArticleDetailVO implements Serializable {

    
    /**
     * 主键，同步文章ID 
     */
    private Long id;
    
    /**
     * 文章内容 
     */
    private String content;

    /**
     * 原始内容
     */
    private String originalContent;
    
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
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
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

