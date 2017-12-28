package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: CommentVO 值对象
 * @author: sangaizhi
 * @date: 2017-09-26 23:18:51
 */
public class CommentVO implements Serializable {

    
    /**
     * 主鍵 
     */
    private Long id;
    
    /**
     * 用户id 
     */
    private Long userId;
    
    /**
     * 用户名称 
     */
    private String userName;
    
    /**
     * 评论的主题类型 
     */
    private Short topic;
    
    /**
     * 评论的主题id 
     */
    private Long topicId;
    
    /**
     * 评论内容 
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
    
    public void setTopic(Short topic) {
        this.topic = topic;
    }

    public Short getTopic() {
        return this.topic;
    }
    
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getTopicId() {
        return this.topicId;
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

