package org.sangaizhi.blog.portal.exception;

import cn.zyunc.ueasier.commons.exception.BusinessRuntimeException;
import org.sangaizhi.common.constant.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.net.BindException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);


    /**
     * 处理缺少请求参数的异常
     * @param e 异常信息
     * @return 处理响应结果
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        logger.error("缺少请求参数", e);
        return ResponseResult.build(false,"缺少请求参数");
    }

    /**
     * 处理参数解析异常
     * @param e 异常信息
     * @return 处理响应结果
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        logger.error("参数解析失败", e);
        return ResponseResult.build(false, "参数解析失败");
    }

    /**
     * 处理参数验证异常
     * @param e 异常信息
     * @return 处理响应结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.error("方法参数验证失败", e);
        return ResponseResult.build(false,"参数解析失败");
    }

    /**
     * 处理参数绑定异常
     * @param e 异常信息
     * @return 处理响应结果
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleBindException(BindException e){
        logger.error("参数绑定失败", e);
        return ResponseResult.build(false, "参数解析失败");
    }

    /**
     * 处理约束异常
     * @param e 异常信息
     * @return 处理响应结果
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult handleConstraintViolationException(ConstraintViolationException e){
        logger.error("参数验证失败", e);
        return ResponseResult.build(false, "参数验证失败");
    }

    /**
     * 处理验证失败
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseResult handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        return ResponseResult.build(false,  "验证失败");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseResult handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return ResponseResult.build(false,  "不支持当前媒体类型");
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessRuntimeException.class)
    public ResponseResult handleServiceException(BusinessRuntimeException e) {
        logger.error("业务逻辑异常", e);
        return ResponseResult.build(false,  "业务逻辑异常：" + e.getMessage());
    }

    /**
     * 处理未知异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e) {
        logger.error("通用异常", e);
        return ResponseResult.build(false,  "通用异常：" + e.getMessage());
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseResult handleException(DataIntegrityViolationException e) {
        logger.error("操作数据库出现异常:", e);
        return ResponseResult.build(false,  "操作数据库出现异常：字段重复、有外键关联等");
    }


}
