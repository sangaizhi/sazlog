package org.sangaizhi.blog.portal.controller;

import org.sangaizhi.blog.entity.qo.ArticleQO;
import org.sangaizhi.blog.entity.vo.ArticleDetailVO;
import org.sangaizhi.blog.entity.vo.ArticleVO;
import org.sangaizhi.blog.service.ArticleDetailService;
import org.sangaizhi.blog.service.ArticleService;
import org.sangaizhi.common.constant.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/31
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDetailService articleDetailService;

    @RequestMapping("/articleList/{categoryId}/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseResult articleList(@PathVariable(name = "categoryId", required = false) Long categoryId, @PathVariable(name = "pageNum",
            required = false) Integer pageNum, @PathVariable(name = "pageSize", required = false) Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 10;
        }
        ArticleQO articleQO = new ArticleQO();
        articleQO.setCategoryId(categoryId);
        articleQO.setPageNum(pageNum);
        articleQO.setPageSize(pageSize);
        List<ArticleVO> articleList = new ArrayList<>();
        return ResponseResult.ok("ok", articleList);
    }

    @RequestMapping("/article/{id}")
    @ResponseBody
    public ResponseResult article(@PathVariable(name = "id") Long id){
        ArticleVO article = articleService.getById(id);
        return ResponseResult.ok("ok", article);
    }

    @RequestMapping("/articleDetail/{id}")
    @ResponseBody
    public ResponseResult articleDetail(@PathVariable(name="id") Long id){
        ArticleDetailVO articleDetail = articleDetailService.getById(id);
        return ResponseResult.ok("ok", articleDetail);
    }

}
