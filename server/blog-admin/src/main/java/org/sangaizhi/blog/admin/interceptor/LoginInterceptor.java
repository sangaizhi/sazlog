package org.sangaizhi.blog.admin.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.sangaizhi.blog.admin.util.cache.RedisCache;
import org.sangaizhi.blog.entity.vo.AdminVO;
import org.sangaizhi.common.constant.ResponseResult;
import org.sangaizhi.common.constant.SystemConstant;
import org.sangaizhi.common.util.CookieUtils;
import org.sangaizhi.common.util.JacksonUtil;
import org.sangaizhi.common.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * 登录拦截器
 * @author sangaizhi
 * @date 2017/9/9
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private RedisCache redisCache;

    /**
     * redis 缓存用户的token
     */
    @Value("${REDIS_ADMIN_SESSION_KEY}")
    private String REDIS_ADMIN_SESSION_KEY;

    /**
     * redis  缓存过期时间
     */
    @Value("${SSO_SESSION_EXPIRE}")
    private Long SSO_SESSION_EXPIRE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //在Handler执行之前处理
        //判断用户是否登录
        //从cookie中取token
        String token = request.getHeader("Authorization");
        if(StringUtils.isBlank(token)){
            ResponseResult responseResult = ResponseResult.fail("未登录");
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(JacksonUtil.toJson(responseResult));
            return false;
        }
        //根据token换取用户信息，调用sso系统的接口。
        AdminVO admin = redisCache.getCache(token, AdminVO.class);
        //取不到用户信息
        if (null == admin) {
            //跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            ResponseResult responseResult = ResponseResult.fail("未登录");
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(JacksonUtil.toJson(responseResult));
            //返回false
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String token = CookieUtils.getCookieValue(request, SystemConstant.ADMIN_TOKEN_COOKIE_KEY);
        redisCache.expireCache(token, SSO_SESSION_EXPIRE);
    }
}
