package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SiteVO 值对象
 * @author: sangaizhi
 * @date: 2017-09-27 22:22:12
 */
public class SiteVO implements Serializable {

    
    /**
     * 主键 
     */
    private Long id;
    
    /**
     * 名称 
     */
    private String name;
    
    /**
     * 链接 
     */
    private String link;
    
    /**
     * logo 图片地址 
     */
    private String logo;
    
    /**
     * 描述文本 
     */
    private String description;
    
    /**
     * 备注 
     */
    private String remark;
    
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
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return this.logo;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
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

