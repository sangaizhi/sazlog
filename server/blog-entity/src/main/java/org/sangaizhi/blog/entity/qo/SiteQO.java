package org.sangaizhi.blog.entity.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: SiteQO 查询对象
 * @author: sangaizhi
 * @date: 2017-09-27 22:22:12
 */
public class SiteQO implements Serializable {

    
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
    
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
