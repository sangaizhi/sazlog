package org.sangaizhi.blog.entity.qo;

import org.sangaizhi.common.vo.Paginate;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserAttentionQO 查询对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:03:14
 */
public class UserAttentionQO extends Paginate implements Serializable {

    
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
    
    public Long getUserid() {
        return this.userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    
    public Long getAttentionUserId() {
        return this.attentionUserId;
    }
    
    public void setAttentionUserId(Long attentionUserId) {
        this.attentionUserId = attentionUserId;
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
