package com.zckj.vmms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring boot 方式--全局
 * 针对对某个Controller类或者方法可使用@CrossOrigin注解
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET,POST,PUT,DELETE,HEAD,OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false).maxAge(3600);
    }
}
