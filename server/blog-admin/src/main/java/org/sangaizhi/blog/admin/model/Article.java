package org.sangaizhi.blog.admin.model;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * @author sangaizhi
 * @date 2017/9/16
 */
public class Article {

    /**
     * 主键
     */
    private Long id;

    /**
     * 发表人
     */
    private Long userId;

    /**
     * 发表人昵称（冗余数据，方便）
     */
    private String userName;

    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 概要
     */
    private String summary;

    /**
     * 标签
     */
    private String label;

    /**
     * 标签集合
     */
    private Set<String> labelSet;

    /**
     * 文章分类ID
     */
    private Long categoryId;

    /**
     * 文章分类名称（冗余数据，方便查询）
     */
    private String categoryName;

    /**
     * 点赞数
     */
    private Integer star;

    /**
     * 内容
     */
    @NotNull(message = "内容不能为空")
    private String content;

    /**
     * 原始内容
     */
    @NotNull(message = "内容不能为空")
    private String originalContent;



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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<String> getLabelSet() {
        return labelSet;
    }

    public void setLabelSet(Set<String> labelSet) {
        this.labelSet = labelSet;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getStar() {
        return this.star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

}
