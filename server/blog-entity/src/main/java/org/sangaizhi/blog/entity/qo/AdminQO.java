package org.sangaizhi.blog.entity.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: AdminQO 查询对象
 * @author: sangaizhi
 * @date: 2017-09-08 23:12:20
 */
public class AdminQO implements Serializable {

    
    /**
     * 主鍵
     */
    private Long id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 密碼
     */
    private String password;
    
    /**
     * 电话
     */
    private String phone;
    
    /**
     * email
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;
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
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
