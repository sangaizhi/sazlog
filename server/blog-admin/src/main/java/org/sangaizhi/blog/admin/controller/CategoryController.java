package org.sangaizhi.blog.admin.controller;

import org.sangaizhi.blog.entity.qo.CategoryQO;
import org.sangaizhi.blog.entity.vo.CategoryVO;
import org.sangaizhi.blog.service.CategoryService;
import org.sangaizhi.common.constant.LogConstants;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/9/10
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类列表
     * @return
     */
    @RequestMapping(value = "/list", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult list(){
        CategoryQO qo = new CategoryQO();
        qo.setParentId(0L);
        List<CategoryVO> list = categoryService.queryList(qo);
        return ResponseResult.ok("查询成功", list);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult delete(@PathVariable Long id){
        try{
            categoryService.deleteById(id);
            return ResponseResult.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(LogConstants.LOG_EXCEPTION_MODEL_DELETE, "删除分类失败!", id);
            return ResponseResult.fail("删除失败");
        }
    }

    /**
     * 新增分类
     * @param category 分类数据
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult add( CategoryVO category){
        try{
            category.setParentId(0L);
            category.setUserId(0L);
            categoryService.save(category);
            return ResponseResult.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(LogConstants.LOG_EXCEPTION_MODEL_DELETE, "新增分类失败!", category);
            return ResponseResult.fail("新增失败");
        }
    }


    /**
     * 获取分类数据
     * @param id 分类Id
     * @return
     */
    @RequestMapping(value = "/getById/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult getById(@PathVariable Long id){
        CategoryVO category = categoryService.getById(id);
        if(null != category){
            return ResponseResult.ok("查询成功", JacksonUtil.toJson(category));
        }else{
            return ResponseResult.fail("查询失败");
        }
    }

    /**
     * 修改分类
     * @param category 分类数据
     * @return
     */
    @RequestMapping(value = "/edit", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult edit(  CategoryVO category){
        if(null == category.getId()){
            return ResponseResult.fail("参数错误");
        }
        try{ CategoryVO categoryVO = new CategoryVO();
            categoryVO.setId(category.getId());
            categoryVO.setName(category.getName());
            categoryVO.setRemark(category.getRemark());
            categoryVO.setModifyTime(new Date());
            categoryService.updateById(categoryVO);
            return ResponseResult.ok("修改成功");
        }catch (Exception e){
            return ResponseResult.fail("修改失败");
        }

    }

}
