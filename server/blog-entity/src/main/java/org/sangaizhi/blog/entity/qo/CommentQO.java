package org.sangaizhi.blog.entity.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: CommentQO 查询对象
 * @author: sangaizhi
 * @date: 2017-09-26 23:18:51
 */
public class CommentQO implements Serializable {

    
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
     * 创建时间
     */
    private Date createTimeBegin;

    /**
     * 创建时间
     */
    private Date createTimeEnd;
    /**
     * 修改时间
     */
    private Date modifyTime;
    
    /**
     * 修改时间
     */
    private Date modifyTimeBegin;

    /**
     * 修改时间
     */
    private Date modifyTimeEnd;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Short getTopic() {
        return this.topic;
    }
    
    public void setTopic(Short topic) {
        this.topic = topic;
    }
    
    public Long getTopicId() {
        return this.topicId;
    }
    
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }  
    
    public Date getCreateTimeBegin() {
        return this.createTimeBegin;
    }
    
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }    
    
    public Date getCreateTimeEnd() {
        return this.createTimeEnd;
    }
    
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public Date getModifyTime() {
        return this.modifyTime;
    }
    
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }  
    
    public Date getModifyTimeBegin() {
        return this.modifyTimeBegin;
    }
    
    public void setModifyTimeBegin(Date modifyTimeBegin) {
        this.modifyTimeBegin = modifyTimeBegin;
    }    
    
    public Date getModifyTimeEnd() {
        return this.modifyTimeEnd;
    }
    
    public void setModifyTimeEnd(Date modifyTimeEnd) {
        this.modifyTimeEnd = modifyTimeEnd;
    }
}
