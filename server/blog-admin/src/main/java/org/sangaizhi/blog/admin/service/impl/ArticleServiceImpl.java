package org.sangaizhi.blog.admin.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.admin.model.Article;
import org.sangaizhi.blog.admin.service.ArticleService;
import org.sangaizhi.blog.admin.util.cache.RedisCache;
import org.sangaizhi.blog.entity.qo.ArticleQO;
import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.blog.entity.vo.ArticleDetailVO;
import org.sangaizhi.blog.entity.vo.ArticleVO;
import org.sangaizhi.blog.entity.vo.CategoryVO;
import org.sangaizhi.blog.service.ArticleDetailService;
import org.sangaizhi.blog.service.CategoryService;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.constant.SystemConstant;
import org.sangaizhi.common.util.CookieUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author sangaizhi
 * @date 2017/9/16
 */
@Service("adminArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private org.sangaizhi.blog.service.ArticleService articleService;

    @Autowired
    private ArticleDetailService articleDetailService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult save(Article article, HttpServletRequest request) {

        // 设置label
        setArticleLabel(article);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);

        // 設置 user
        String token = CookieUtils.getCookieValue(request, SystemConstant.ADMIN_TOKEN_COOKIE_KEY);
        AdminVO admin = redisCache.getCache(token, AdminVO.class);
        articleVO.setUserId(admin.getId());
        articleVO.setUserName(admin.getName());
        setArticleCategory(articleVO);
        setArticleSummary(article, articleVO);
        articleVO.setStar(0);
        articleVO.setCreateTime(new Date());
        articleService.save(articleVO);

        ArticleDetailVO articleDetail = new ArticleDetailVO();
        articleDetail.setContent(article.getContent());
        articleDetail.setOriginalContent(article.getOriginalContent());
        articleDetail.setId(articleVO.getId());
        articleDetail.setCreateTime(new Date());
        articleDetailService.save(articleDetail);

        return ResponseResult.ok("保存成功");
    }

    @Override
    public ResponseResult edit(Article article, HttpServletRequest request) {
        // 设置label
        setArticleLabel(article);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        // 設置 user
        String token = CookieUtils.getCookieValue(request, SystemConstant.ADMIN_TOKEN_COOKIE_KEY);
        AdminVO admin = redisCache.getCache(token, AdminVO.class);
        article.setUserId(admin.getId());
        article.setUserName(admin.getName());
        setArticleCategory(articleVO);
        setArticleSummary(article, articleVO);
        articleVO.setModifyTime(new Date());
        articleService.updateById(articleVO);

        ArticleDetailVO articleDetail = articleDetailService.getById(articleVO.getId());
        if(null == articleDetail){
            articleDetail = new ArticleDetailVO();
            articleDetail.setId(articleVO.getId());
            articleDetail.setContent(article.getContent());
            articleDetail.setOriginalContent(article.getOriginalContent());
            articleDetail.setCreateTime(new Date());
            articleDetailService.save(articleDetail);
        }else{
            articleDetail.setContent(article.getContent());
            articleDetail.setOriginalContent(article.getOriginalContent());
            articleDetail.setCreateTime(new Date());
            articleDetail.setModifyTime(new Date());
            articleDetailService.updateById(articleDetail);
        }
        return ResponseResult.ok("保存成功");
    }

    private void setArticleSummary(Article article, ArticleVO articleVO) {
        // 设置 summary
        if(StringUtils.isBlank(article.getSummary())){
            String content = article.getContent();
            if(StringUtils.isNotBlank(content)){
                String summary = content.length() > 150 ? content.substring(0, 149) : content;
                articleVO.setSummary(summary);
            }
        }
    }

    private void setArticleCategory(ArticleVO articleVO) {
        // 设置分类
        if(null != articleVO.getCategoryId()){
            CategoryVO category = categoryService.getById(articleVO.getCategoryId());
            if(null != category){
                articleVO.setCategoryName(category.getName());
            }
        }
    }

    private void setArticleLabel(Article article) {
        String label = article.getLabel();
        if(StringUtils.isNotBlank(label)){
            String[] labels = label.split(",");
            StringBuilder labelBuffer = new StringBuilder();
            if(labels.length > 0){
                for(String tempLabel : labels){
                    if(StringUtils.isNotBlank(tempLabel)){
                        labelBuffer.append(",").append(tempLabel);
                    }
                }
                String newLabel = labelBuffer.toString();
                article.setLabel(StringUtils.isNotBlank(newLabel) ? newLabel.substring(1, newLabel.length()) : null);
            }else{
                article.setLabel(null);
            }
        }else{
            article.setLabel(null);
        }
    }

    @Override
    public List<Article> queryPage(ArticleQO articleQO) {
        if(null == articleQO){
            articleQO = new ArticleQO();
        }
        if(null == articleQO.getPageNum()){
            articleQO.setPageNum(1);
        }
        if(null == articleQO.getPageSize()){
            articleQO.setPageSize(0);
        }
        List<ArticleVO> articleVOList = articleService.queryPage(articleQO);
        if(CollectionUtils.isNotEmpty(articleVOList)){
            List<Article> articleList = new ArrayList<>();
            Article article;
            for(ArticleVO temp : articleVOList){
                article = new Article();
                String[] labelArray;
                BeanUtils.copyProperties(temp, article);
                if(StringUtils.isNotBlank(temp.getLabel())){
                    labelArray = temp.getLabel().split(",");
                    article.setLabelSet(new HashSet<String>(Arrays.asList(labelArray)));
                }
                articleList.add(article);
            }
            return articleList;
        }else {
            return new ArrayList<Article>();
        }
    }

    @Override
    public Long count(ArticleQO articleQO) {
        if(null == articleQO){
            articleQO = new ArticleQO();
        }
        return articleService.count(articleQO);
    }

    @Override
    public Article getById(Long id) {
        ArticleVO articleVO = articleService.getById(id);
        Article article = new Article();
        BeanUtils.copyProperties(articleVO, article);
        ArticleDetailVO articleDetail = articleDetailService.getById(id);
        if(null != articleDetail){
            article.setContent(articleDetail.getContent());
            article.setOriginalContent(articleDetail.getOriginalContent());
        }
        return article;
    }

    @Override
    public void delete(Long id) {
        articleService.deleteById(id);
        articleDetailService.deleteById(id);
    }
}
