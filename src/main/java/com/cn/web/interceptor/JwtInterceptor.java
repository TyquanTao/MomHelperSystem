package com.cn.web.interceptor;


import com.cn.exception.JwtException;
import com.cn.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:Teacher黄
 * @date:Created at 2019/11/25
 */

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 先从请求头里面去获取jwt token
        String token = request.getHeader("Authorization");
        // 验证是否为空
        if (StringUtils.isEmpty(token)) {
            throw new JwtException(6001,"token 为空!");
        }

        // 获取用户id
        Integer userId = JwtUtil.getUserId(token);
        if(userId == null){
            throw new JwtException(6002,"token 不正确!请重新登陆!");
        }

        // 验证token
        if (!JwtUtil.verify(token,userId)) {
            throw new JwtException(6002,"token 不正确!请重新登陆!");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
