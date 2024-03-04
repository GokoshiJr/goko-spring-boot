package com.goko.Interceptores;

import com.goko.Interceptores.interceptors.BasicInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AppConfig implements WebMvcConfigurer {
    @Qualifier("basicInterceptor")
    private HandlerInterceptor basicInterceptor;

    public AppConfig(BasicInterceptor basicInterceptor) {
        this.basicInterceptor = basicInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(basicInterceptor).excludePathPatterns("/api/home");
        registry.addInterceptor(basicInterceptor).addPathPatterns("/api/foo", "/api/bar");
    }
}
