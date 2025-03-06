package com.wave.counseling.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wave.counseling.utils.SessionManager;
import com.wave.counseling.web.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ziwei.huang
 * @date 2025/3/6 09:26
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        if ("OPTIONS".equals(request.getMethod().toUpperCase())){

            return true;
        }
        String url = request.getRequestURI();
        // URL:除了登录请求外，其他的URL都进行拦截控制
        if (url.indexOf("/register") >= 0 || url.indexOf("auth") >= 0 || url.indexOf("/logout") >= 0) {
            return true;
        }
        // 获取Session
        final String session = request.getHeader("Session");

        if (session != null && SessionManager.find(session) != null) {
            return true;
        }
//        // 不符合条件的，跳转到登录界面
//        request.getRequestDispatcher("/auth").forward(request, response);
        ObjectMapper mapper = new ObjectMapper();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.sendRedirect("/login");
        response.getWriter().write(mapper.writeValueAsString(Result.intercepted()));
        return false;
    }
}
