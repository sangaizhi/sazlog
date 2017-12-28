package org.sangaizhi.blog.entity.qo;

import org.sangaizhi.common.vo.Paginate;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: UserExtraQO 查询对象
 * @author: sangaizhi
 * @date: 2017-08-22 23:00:39
 */
public class UserExtraQO extends Paginate implements Serializable {

    
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
     * 出生日期
     */
    private Date birthBegin;

    /**
     * 出生日期
     */
    private Date birthEnd;
    
    /**
     * 居住地址
     */
    private String address;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Short getSex() {
        return this.sex;
    }
    
    public void setSex(Short sex) {
        this.sex = sex;
    }
    public Date getBirth() {
        return this.birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }  
    
    public Date getBirthBegin() {
        return this.birthBegin;
    }
    
    public void setBirthBegin(Date birthBegin) {
        this.birthBegin = birthBegin;
    }    
    
    public Date getBirthEnd() {
        return this.birthEnd;
    }
    
    public void setBirthEnd(Date birthEnd) {
        this.birthEnd = birthEnd;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
