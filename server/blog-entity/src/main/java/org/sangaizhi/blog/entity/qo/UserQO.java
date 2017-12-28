package org.sangaizhi.blog.entity.qo;

import org.sangaizhi.common.vo.Paginate;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserQO 查询对象
 * @author: sangaizhi
 * @date: 2017-08-22 22:56:30
 */
public class UserQO extends Paginate implements Serializable {

    
    /**
     * 主键
     */
    private Long id;

    private String keyword;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private Short status;
    
    /**
     * 昵称
     */
    private String nickname;
    
    /**
     * 用户头像地址
     */
    private String profile;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getProfile() {
        return this.profile;
    }
    
    public void setProfile(String profile) {
        this.profile = profile;
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
