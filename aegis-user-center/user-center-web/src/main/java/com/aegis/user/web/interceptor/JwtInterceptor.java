package com.aegis.user.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT 鉴权拦截器 (预留设计)
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 预留鉴权逻辑：从请求头获取 token 并验证
        String token = request.getHeader("Authorization");
        
        // 此处暂不实现完整验证逻辑，直接放行
        // 如果验证失败，可抛出异常或设置 response 状态码并返回 false
        
        return true;
    }
}