package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Config extends WebMvcConfigurerAdapter {
    @Bean
    public MyInterceptor1 getSessionInterceptor() {
        return new MyInterceptor1();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*调用我们创建的SessionInterceptor。
         * addPathPatterns("/**)的意思是这个链接下的都要进入到SessionInterceptor里面去执行
         * excludePathPatterns("/login")的意思是login的url可以不用进入到SessionInterceptor中，直接
         * 放过执行。
         *
         * 注意：如果像注释那样写是不可以的。这样等于是创建了多个Interceptor。而不是只有一个Interceptor
         * 所以这里有个大坑，搞了很久才发现问题。
         *
         * */
        MyInterceptor1 sessionInterceptor=new MyInterceptor1();
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login**","/css/**","/jquery-3.5.1.js","/js/**","/img/**","/mapper/**","/htmlWeb/**","/layui/**");
//        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/login");
//        registry.addInterceptor(sessionInterceptor).excludePathPatterns("/verify");

        super.addInterceptors(registry);
    }
}










































//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import javax.annotation.Resource;
//
///**
// * @author 夏龙
// * @date 2020-11-24
// */
//@Configuration
//public class Config extends WebMvcConfigurationSupport {
//
//
//    @Bean
//    public MyInterceptor1 getSessionInterceptor() {
//        return new MyInterceptor1();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        MyInterceptor1 baseInterceptor=new MyInterceptor1();
//        registry.addInterceptor(baseInterceptor).addPathPatterns("/**")
//                //需要配置2：----------- 告知拦截器：/static/admin/** 与 /static/user/** 不需要拦截 （配置的是 路径）
//                .excludePathPatterns("/static","/loginIn","/register", "/templates/**","/js/**","/img/**","/css/**");
//
//        super.addInterceptors(registry);
//    }
//
//    /**
//     * 解除静态资源访问拦截，外部可以直接访问地址
//     *
//     * @param registry
//     */
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/META-INF/resources/", "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/","classpath:/static/css/"};
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!registry.hasMappingForPattern("/webjars/**")) {
//            registry.addResourceHandler("/webjars/**").addResourceLocations(
//                    "classpath:/META-INF/resources/webjars/");
//        }
//        if (!registry.hasMappingForPattern("/**")) {
//            registry.addResourceHandler("/**").addResourceLocations(
//                    CLASSPATH_RESOURCE_LOCATIONS);
//        }
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
//    }
//
//
//}
//
//
