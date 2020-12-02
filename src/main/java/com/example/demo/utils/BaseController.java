package com.example.demo.utils;

import com.example.demo.bean.UserBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author 夏龙
 * @date 2020-12-01
 */
public  class BaseController {
    /**
     * 当前账号常量
     */
    private static final String USERBEAN = "user";


    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public UserBean getUserBean() {
        HttpSession session = getRequest().getSession();
        return (UserBean) session.getAttribute(USERBEAN);
    }

    public void setToken(String token) {
        HttpSession session = getRequest().getSession();
        if (token != null) {
            session.setAttribute(USERBEAN, token);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(1 * 60);
        }
    }

}
