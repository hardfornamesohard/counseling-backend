package com.wave.counseling.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ziwei.huang
 * @date 2025/3/7 16:57
 */
//@Component
public class BaseInterceptor implements HandlerInterceptor {
    List<String> includeUrls = new ArrayList<>();
    List<String> excludeUrls = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public BaseInterceptor() {
        excludeUrls.add("/login");
        excludeUrls.add("/logout");
        excludeUrls.add("/register");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equals(request.getMethod().toUpperCase())){

            return true;
        }
        String url = request.getRequestURI();
        // URL:除了登录请求外，其他的URL都进行拦截控制
        if (!excludeUrls.contains(url)) {
            return false;
        }
        return true;
    }
}
