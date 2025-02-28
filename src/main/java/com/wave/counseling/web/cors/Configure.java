package com.wave.counseling.web.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configure implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径跨域
                .allowedOrigins("http://localhost:3000") // 允许来自 http://localhost:3000 的请求
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                .allowedHeaders("*") // 允许所有请求头
                .exposedHeaders("Session") // 暴露 Session 头给前端
                .allowCredentials(true); // 如果需要支持 cookies 等凭证，设置为 true
    }
}

