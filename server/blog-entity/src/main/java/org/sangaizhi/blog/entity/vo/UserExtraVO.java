package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserExtraVO 值对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:00:39
 */
public class UserExtraVO implements Serializable {

    
    /**
     * 主键,同步用户主表 
     */
    private Long id;
    
    /**
     * 性别 
     */
    private Short sex;
    
    /**
     * 出生日期 
     */
    private Date birth;
    
    /**
     * 居住地址 
     */
    private String address;

    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Short getSex() {
        return this.sex;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return this.birth;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }
}

