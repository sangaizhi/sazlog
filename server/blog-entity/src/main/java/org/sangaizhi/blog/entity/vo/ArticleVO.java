package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ArticleVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:19:25
 */
public class ArticleVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 发表人 
     */
    private Long userId;
    
    /**
     * 发表人昵称（冗余数据，方便） 
     */
    private String userName;
    
    /**
     * 标题 
     */
    private String title;

    /**
     * 概要
     */
    private String summary;

    /**
     * 标签
     */
    private String label;
    
    /**
     * 文章分类ID 
     */
    private Long categoryId;
    
    /**
     * 文章分类名称（冗余数据，方便查询） 
     */
    private String categoryName;
    
    /**
     * 点赞数 
     */
    private Integer star;
    
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
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getStar() {
        return this.star;
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

