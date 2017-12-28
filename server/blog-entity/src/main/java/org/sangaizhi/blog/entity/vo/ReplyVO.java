package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ReplyVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:10:44
 */
public class ReplyVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 评论ID 
     */
    private Long commentId;
    
    /**
     * 回复内容 
     */
    private String content;
    
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
    
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return this.commentId;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
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

