package org.sangaizhi.blog.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.entity.qo.KitBoxQO;
import org.sangaizhi.blog.entity.vo.KitBoxVO;
import org.sangaizhi.blog.service.KitBoxService;
import org.sangaizhi.common.constant.LogConstants;
import org.sangaizhi.common.constant.ResponseData;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.exception.BusinessRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/9/27
 */
@Controller
@RequestMapping("/kitbox")
public class KitBoxController {

    private static final Logger logger = LoggerFactory.getLogger(KitBoxController.class);

    @Autowired
    private KitBoxService kitBoxService;

    @Autowired
    @Qualifier("adminKitBoxService")
    private org.sangaizhi.blog.admin.service.KitBoxService adminKitBoxService;

    @RequestMapping(value = "/list", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult list(KitBoxQO qo){
        if(null == qo){
            qo = new KitBoxQO();
        }
        List<KitBoxVO> list = kitBoxService.queryList(qo);
        ResponseData data = new ResponseData(list, null);
        return ResponseResult.ok("查询成功", data);
    }

    @RequestMapping(value = "/rename/{id}/{name}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult rename(@PathVariable Long id, @PathVariable String name){
        if(null == id || StringUtils.isBlank(name)){
            return ResponseResult.fail("参数错误");
        }
     try{
         adminKitBoxService.rename(id, name);
     }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "重命名工具箱出现异常", id);
            return ResponseResult.fail(e.getErrMsg());
     }catch (Exception e){
         e.printStackTrace();
         logger.error(LogConstants.LOG_INFO_MODEL_BUSSINESS, "重命名工具箱出现异常", id);
         return ResponseResult.fail("重命名失败");
     }
        return ResponseResult.ok("重命名成功");
    }

    @RequestMapping(value = "/delete/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult delete(@PathVariable Long id){
        if(null == id){
            return ResponseResult.fail("参数错误");
        }
        try{
            adminKitBoxService.delete(id);
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.info(LogConstants.LOG_INFO_MODEL_BUSSINESS, "删除工具箱出现异常", id);
            return ResponseResult.fail(e.getErrMsg());
        }catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_INFO_MODEL_BUSSINESS, "删除工具箱出现异常", id);
            return ResponseResult.fail("删除失败");
        }
        return ResponseResult.ok("删除成功");
    }


    /**
     * 新增工具集
     * @param kitBox
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult add(KitBoxVO kitBox){
        if(null == kitBox || StringUtils.isBlank(kitBox.getName())){
            return ResponseResult.fail("参数错误");
        }
        try{
            kitBox.setCreateTime(new Date());
            kitBoxService.save(kitBox);
            return ResponseResult.ok("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "新增工具集出现异常", kitBox);
            return ResponseResult.fail("保存失败");
        }
    }

    @RequestMapping(value = "/edit", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult edit(KitBoxVO kitBox){
        if(null == kitBox){
            return ResponseResult.fail("参数错误");
        }
        if(null == kitBox.getId() || StringUtils.isBlank(kitBox.getName())){
            return ResponseResult.fail("参数错误");
        }
        kitBox.setModifyTime(new Date());
        try{
            kitBoxService.updateById(kitBox);
            return ResponseResult.ok("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "编辑工具集出现异常", kitBox);
            return ResponseResult.fail("保存失败");
        }
    }


}
