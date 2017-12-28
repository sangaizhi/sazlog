package org.sangaizhi.blog.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: KitVO 值对象
 * @author: sangaizhi
 * @date: 2017-09-27 22:16:39
 */
public class KitVO implements Serializable {

    
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
     * logo
     */
    private String logo;

    /**
     * 描述
     */
    private String description;
    
    /**
     * 所属工具箱 
     */
    private Long kitBoxId;
    
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKitBoxId(Long kitBoxId) {
        this.kitBoxId = kitBoxId;
    }

    public Long getKitBoxId() {
        return this.kitBoxId;
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

