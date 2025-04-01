package com.wave.counseling.web.config;

import com.wave.counseling.interceptor.BaseInterceptor;
import com.wave.counseling.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor interceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取当前用户目录
        String userDir = System.getProperty("user.dir");
        String resourceLocation = "file:" + userDir + "/images/avatar/";
        System.out.println(resourceLocation);

        registry.addResourceHandler("/images/avatar/**")
                .addResourceLocations(resourceLocation);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(interceptor);

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

