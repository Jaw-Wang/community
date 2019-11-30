package com.example.community.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: create by Jaw
 * @Date:2019/11/30
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(new LocaleChangeInterceptor());*/
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
        /*registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");*/
        /*registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");*/
    }
}