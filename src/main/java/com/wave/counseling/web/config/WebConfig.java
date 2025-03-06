package com.wave.counseling.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取当前用户目录
        String userDir = System.getProperty("user.dir");
        String resourceLocation = "file:" + userDir + "/images/avatar/";

        registry.addResourceHandler("/images/avatar/**")
                .addResourceLocations(resourceLocation);
    }
}

