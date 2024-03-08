package com.goko.TimeInterceptor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Qualifier("basicInterceptor")
    private HandlerInterceptor basicInterceptor;

    public AppConfig(HandlerInterceptor basicInterceptor) {
        this.basicInterceptor = basicInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(basicInterceptor).excludePathPatterns("/api/home");
        registry.addInterceptor(basicInterceptor).addPathPatterns("/api/foo", "/api/bar");
    }
}
