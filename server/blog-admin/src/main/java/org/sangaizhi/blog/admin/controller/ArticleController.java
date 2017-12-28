package org.sangaizhi.blog.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.admin.model.Article;
import org.sangaizhi.blog.entity.qo.ArticleQO;
import org.sangaizhi.blog.entity.vo.ArticleVO;
import org.sangaizhi.blog.service.ArticleService;
import org.sangaizhi.common.constant.ResponseData;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.vo.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author sangaizhi
 * @date 2017/9/11
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    @Qualifier("adminArticleService")
    private org.sangaizhi.blog.admin.service.ArticleService adminArticleService;

    @RequestMapping(value = "/list", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult list(ArticleQO qo){
        if(null == qo){
            qo = new ArticleQO();
        }
        if(null == qo.getPageNum()){
            qo.setPageNum(1);
        }
        if(null == qo.getPageSize()){
            qo.setPageSize(10);
        }
        List<Article> articleList = adminArticleService.queryPage(qo);
        Long count = adminArticleService.count(qo);
        Paginate paginate = new Paginate(qo.getPageNum(), qo.getPageSize(), count);
        return ResponseResult.ok("查询成功", new ResponseData(articleList, paginate));
    }

    @RequestMapping(value = "/add", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult add(Article article, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            String[] errorMsg = new String[errors.size()];
            int i = 0;
            for(ObjectError error : errors){
                errorMsg[i++] = error.getDefaultMessage();
            }
            return ResponseResult.fail(StringUtils.join(errorMsg, "\n"));
        }
        ResponseResult result = adminArticleService.save(article, request);
        return result;

    }
    @RequestMapping(value = "/edit", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult edit(Article article, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            String[] errorMsg = new String[errors.size()];
            int i = 0;
            for(ObjectError error : errors){
                errorMsg[i++] = error.getDefaultMessage();
            }
            return ResponseResult.fail(StringUtils.join(errorMsg, "\n"));
        }
        ResponseResult result = adminArticleService.edit(article, request);
        return result;

    }

    @RequestMapping(value = "/getById/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult getById(@PathVariable Long id){
        Article article = adminArticleService.getById(id);
        return ResponseResult.ok("获取成功", article);
    }


    @RequestMapping(value = "/delete/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult delete(@PathVariable Long id){
        adminArticleService.delete(id);
        return ResponseResult.ok("删除成功");
    }

    @RequestMapping(value = "/deleteLabel", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult deleteLabel(@RequestParam Long id,@RequestParam String label){
        ArticleVO articleVO = articleService.getById(id);
        if(null == articleVO){
            return ResponseResult.fail("没找到对应文章");
        }
        if(StringUtils.isBlank(label)){
            return ResponseResult.fail("参数错误");
        }
        String oldLabels = articleVO.getLabel();
        if(StringUtils.isNotBlank(oldLabels)){
            String[] oldLabelArray = oldLabels.split(",");
            if(oldLabelArray.length > 0){
                StringBuilder labelBuilder = new StringBuilder();
                for(String tempLabel : oldLabelArray){
                    if(!Objects.equals(tempLabel.trim(), label.trim())){
                        labelBuilder.append(tempLabel).append(",");
                    }
                }
                String newLabel = labelBuilder.toString();
                if(StringUtils.isNotBlank(newLabel)){
                    newLabel =labelBuilder.substring(0, newLabel.lastIndexOf(","));
                }else{
                    newLabel = "";
                }
                articleVO.setLabel(newLabel);
                articleService.updateById(articleVO);
                return ResponseResult.ok("刪除成功");
            }else{
                return ResponseResult.fail("沒有找到对应标签");
            }
        }else{
            return ResponseResult.fail("沒有找到对应标签");
        }
    }
}
