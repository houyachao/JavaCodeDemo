package com.example.javacodedemo.config;

import com.example.javacodedemo.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HYC
 */
@Configurable
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/api/users/save")
                .addPathPatterns("/api/users/update")
                .addPathPatterns("/api/users/get")
                .excludePathPatterns("/api/users/login")
        ;
    }
}
