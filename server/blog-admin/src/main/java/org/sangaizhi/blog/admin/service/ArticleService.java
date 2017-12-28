package org.sangaizhi.blog.admin.service;

import org.sangaizhi.blog.admin.model.Article;
import org.sangaizhi.blog.entity.qo.ArticleQO;
import org.sangaizhi.common.constant.ResponseData;
import org.sangaizhi.common.constant.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created by sangaizhi on 2017/9/16.
 */
public interface ArticleService {

    /**
     * 新增文章
     * @param article 文章内容
     * @param request 当前请求
     * @return
     */
    ResponseResult save(Article article, HttpServletRequest request);

    /**
     * 编辑文章
     * @param article 文章内容
     * @param request 当前请求
     * @return
     */
    ResponseResult edit(Article article, HttpServletRequest request);

    List<Article> queryPage(ArticleQO articleQO);

    Long count(ArticleQO articleQO);

    Article getById(Long id);

    void delete(Long id);

}
