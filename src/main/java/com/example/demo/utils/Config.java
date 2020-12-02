package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author 夏龙
 * @date 2020-11-24
 */
@Configuration
public class Config extends WebMvcConfigurationSupport {


    @Bean
    public MyInterceptor1 getSessionInterceptor() {
        return new MyInterceptor1();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor1 baseInterceptor=new MyInterceptor1();
        registry.addInterceptor(baseInterceptor).addPathPatterns("/**")
                //需要配置2：----------- 告知拦截器：/static/admin/** 与 /static/user/** 不需要拦截 （配置的是 路径）
                .excludePathPatterns("/login","/loginIn","/register", "/templates/**","/js/**","/img/**","/css/**");

        super.addInterceptors(registry);
    }

    /**
     * 解除静态资源访问拦截，外部可以直接访问地址
     *
     * @param registry
     */
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/","classpath:/static/css/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
    }


}


