package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: VisitorVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:23:10
 */
public class VisitorVO implements Serializable {

    
    /**
     * 主鍵 
     */
    private Long id;
    
    /**
     * 用户ID 
     */
    private Long userId;
    
    /**
     * 访客ID 
     */
    private Long visitorId;
    
    /**
     * 访客昵称 
     */
    private String visitorName;
    
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
    
    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getVisitorId() {
        return this.visitorId;
    }
    
    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorName() {
        return this.visitorName;
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

