package com.zckj.vmms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 当访问/file下的资源时，会到/root/myFile/下去找
        // 例如访问：http://localhost:8080/file/1.png时会去找/root/myFile/1.png
        registry.addResourceHandler("/file/**").addResourceLocations("file:/root/myFile/");
        super.addResourceHandlers(registry);
    }
}

