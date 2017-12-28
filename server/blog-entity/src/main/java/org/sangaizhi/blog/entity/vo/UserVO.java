package org.sangaizhi.blog.entity.vo;

import org.hibernate.validator.constraints.Email;
import org.sangaizhi.common.validator.Phone;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 22:56:30
 */
public class UserVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 手机号 
     */
    @NotNull(message = "电话不能为空")
    @Phone(message = "电话格式不正确")
    private String phone;
    
    /**
     * 邮箱 
     */
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 用户状态
     */
    private Short status;

    /**
     * 昵称 
     */
    @NotNull(message = "昵称不能为空")
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
     * 修改时间 
     */
    private Date modifyTime;

    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return this.profile;
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

