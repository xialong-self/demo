package com.example.demo.utils;

import com.example.demo.aop.NoneAuth;

import org.apache.catalina.session.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Enumeration;

/**
 * @author 夏龙
 * @date 2020-11-24
 */
@Component
public class MyInterceptor1 implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //
        String token=request.getHeader("token");
        // 初始化拦截器，设置不拦截路径
        String noMatchPath= "(.*)login(.*)";
        String noMatchPath2= "(.*)tokenMessage(.*)";
        String path=request.getServletPath();

        System.out.println("资源请求路径："+path);
        System.out.println("拦截器从header中获取的token："+token);
        if(path.matches(noMatchPath)||path.matches(noMatchPath2)){
            // 授权路径，不拦截
            System.out.println("不拦截");
            return  true;
        } else if(token == null || "".equals(token)) {
            // 找不到用户Token，重定位到登录
//            response.sendRedirect(request.getContextPath() + "/login");
            System.out.println("token为空，跳转登录页");
            return  false;
        } else if(TokenUse.tokenVerify(token)){
            // 设置扩展
            System.out.println("token验证成功");
            return  true;
        }
        System.out.println("被拦截");
        return false;



    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

    public String addAddress(@RequestHeader("token") String token) {
        System.out.println(token);
        return token;
    }
}
