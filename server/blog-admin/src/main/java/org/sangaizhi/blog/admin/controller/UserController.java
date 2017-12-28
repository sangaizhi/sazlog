package org.sangaizhi.blog.admin.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.entity.qo.UserQO;
import org.sangaizhi.blog.entity.vo.UserVO;
import org.sangaizhi.blog.service.UserService;
import org.sangaizhi.common.constant.LogConstants;
import org.sangaizhi.common.constant.ResponseData;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.dict.UserStatusDict;
import org.sangaizhi.common.exception.BusinessRuntimeException;
import org.sangaizhi.common.util.RegularUtil;
import org.sangaizhi.common.vo.Paginate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author sangaizhi
 * @date 2017/9/23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("adminUserService")
    private org.sangaizhi.blog.admin.service.UserService adminUserService;

    @RequestMapping(value = "/list", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult list(UserQO qo){
        if(null == qo){
            qo = new UserQO();
        }
        if(null == qo.getPageNum()){
            qo.setPageNum(1);
        }
        if(null == qo.getPageSize()){
            qo.setPageSize(10);
        }
        List<UserVO> list = userService.queryPage(qo);
        Long count = userService.count(qo);
        Paginate paginate = new Paginate(qo.getPageNum(), qo.getPageSize(), count);
        return ResponseResult.ok("查询成功", new ResponseData(list, paginate));
    }

    @RequestMapping(value = "/delete/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult delete(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseResult.ok("删除成功");
    }

    /**
     * 激活用戶
     * @param id 用戶id
     * @return
     */
    @RequestMapping(value = "/active/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult active(@PathVariable Long id){
        try{
            adminUserService.updateUserStatus(id, UserStatusDict.ACTIVATED.getValue());
            return ResponseResult.ok("激活成功");
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "激活用戶出现异常", id);
            return ResponseResult.fail("激活失败");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "激活用戶出现异常", id);
            return ResponseResult.fail("激活失败");
        }
    }


    /**
     * 锁定用戶
     * @param id 用戶id
     * @return
     */
    @RequestMapping(value = "/lock/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult lock(@PathVariable Long id){
        try{
            adminUserService.updateUserStatus(id, UserStatusDict.LOCKED.getValue());
            return ResponseResult.ok("锁定成功");
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "锁定用戶出现异常", id);
            return ResponseResult.fail("激活失败");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "锁定用戶出现异常", id);
            return ResponseResult.fail("激活失败");
        }
    }

    /**
     * 锁定用戶
     * @param id 用戶id
     * @return
     */
    @RequestMapping(value = "/unlock/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult unlock(@PathVariable Long id){
        try{
            adminUserService.updateUserStatus(id, UserStatusDict.ACTIVATED.getValue());
            return ResponseResult.ok("解锁成功");
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "解锁用戶出现异常", id);
            return ResponseResult.fail("解锁失败");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "激活用戶出现异常", id);
            return ResponseResult.fail("解锁失败");
        }
    }

    /**
     * 禁用用戶
     * @param id 用戶id
     * @return
     */
    @RequestMapping(value = "/disable/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult disable(@PathVariable Long id){
        try{
            adminUserService.updateUserStatus(id, UserStatusDict.DISABLED.getValue());
            return ResponseResult.ok("禁用成功");
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "禁用用戶出现异常", id);
            return ResponseResult.fail("禁用失败");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "禁用用戶出现异常", id);
            return ResponseResult.fail("禁用失败");
        }
    }

    /**
     * 启用用戶
     * @param id 用戶id
     * @return
     */
    @RequestMapping(value = "/enable/{id}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult enable(@PathVariable Long id){
        try{
            adminUserService.updateUserStatus(id, UserStatusDict.ACTIVATED.getValue());
            return ResponseResult.ok("启用成功");
        }catch (BusinessRuntimeException e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "启用用戶出现异常", id);
            return ResponseResult.fail("启用失败");
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(LogConstants.LOG_ERROR_MODEL, "启用用戶出现异常", id);
            return ResponseResult.fail("启用失败");
        }
    }

    @RequestMapping(value = "/checkPhoneUsable/{phone}", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult checkPhoneUsable(@PathVariable String phone){
        if(StringUtils.isBlank(phone)){
            return ResponseResult.fail("电话格式不正确");
        }
        if(!RegularUtil.checkMobile(phone)){
            return ResponseResult.fail("电话格式不正确");
        }
        UserQO userQO = new UserQO();
        userQO.setPhone(phone);
        List<UserVO> userList = userService.queryList(userQO);
        if(CollectionUtils.isNotEmpty(userList)){
            return ResponseResult.fail("该手机号已经被占用");
        }
        return ResponseResult.ok("该手机号可使用");
    }

    @RequestMapping(value = "/checkEmailUsable", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult checkEmailUsable(@RequestParam String email){
        if(StringUtils.isBlank(email)){
            return ResponseResult.fail("邮箱格式不正确");
        }
        if(!RegularUtil.checkEmail(email)){
            return ResponseResult.fail("邮箱格式不正确");
        }
        UserQO userQO = new UserQO();
        userQO.setEmail(email);
        List<UserVO> userList = userService.queryList(userQO);
        if(CollectionUtils.isNotEmpty(userList)){
            return ResponseResult.fail("该邮箱已经被占用");
        }
        return ResponseResult.ok("该邮箱可使用");
    }

    /**
     * 新增用户
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=utf8"})
    @ResponseBody
    public ResponseResult add( UserVO user, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            String[] errorMsg = new String[errors.size()];
            int i = 0;
            for(ObjectError error : errors){
                errorMsg[i++] = error.getDefaultMessage();
            }
            return ResponseResult.fail(StringUtils.join(errorMsg, "\n"));
        }
        ResponseResult result = adminUserService.save(user);
        return result;
    }

}

