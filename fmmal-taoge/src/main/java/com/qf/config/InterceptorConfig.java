package com.qf.config;

import com.qf.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
//                .excludePathPatterns("/user/**")
//                .excludePathPatterns("/index/**")
//                .excludePathPatterns("/swagger-ui.html")
//                .excludePathPatterns("/doc.html");
                .excludePathPatterns(
                        "/user/**",
                        "/index/**",
                        "/swagger-ui.html",
                        "/doc.html",
                        "/v2/api-docs",        // Swagger API 文档路径
                        "/webjars/**",         // Swagger UI 的静态资源路径
                        "/swagger-resources/**"// Swagger 相关资源路径
                );
    }
}
