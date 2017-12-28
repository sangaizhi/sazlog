package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserAttentionVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:03:14
 */
public class UserAttentionVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 关注者ID 
     */
    private Long userid;
    
    /**
     * 被关注者ID 
     */
    private Long attentionUserId;
    
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
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return this.userid;
    }
    
    public void setAttentionUserId(Long attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public Long getAttentionUserId() {
        return this.attentionUserId;
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

