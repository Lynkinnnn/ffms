//package com.wowo.ffms.config;
//
//import com.wowo.ffms.utils.LoginHandlerInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebappAdapter implements WebMvcConfigurer {
//    // 注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 添加拦截的请求，并排除几个不拦截的请求
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/login.html", "/", "/login","/sendMessage","/messageLogin","/static/**","/**/*.css",
//                        "/**/*.js", "/**/*.png", "/**/*.jpg",
//                        "/**/*.jpeg", "/**/*.gif", "/**/fonts/*","/i18n/**");
//    }
//}
