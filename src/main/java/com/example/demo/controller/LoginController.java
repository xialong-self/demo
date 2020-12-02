package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.aop.NoneAuth;
import com.example.demo.bean.UserBean;
import com.example.demo.service.UserService;
import com.example.demo.utils.BaseController;
import com.example.demo.utils.R;
import com.example.demo.utils.TokenUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @author 夏龙
 * @date 2020-11-23
 */
@Controller
public class LoginController  {

    //将Service注入Web层
    final
    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    Map map = new HashMap();
    @RequestMapping("/login")
    public String show() {
        return "/html/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "/html/register";
    }


    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    @ResponseBody
    public Map login(String name, String password) {
        UserBean userBean = userService.loginIn(name, password);
        System.out.println("");
        if (userBean != null) {
//            String token = TokenUse.sign(userBean.getName(), userBean.getPassword());
            System.out.println("login账户密码验证成功");
//            System.out.println("login 控制层："+token);
            map.put("code",1);
//            map.put("token",token);
            return map;

        } else {
            System.out.println("到控制层，账户密码验证失败");
            map.put("code", 0);
            map.put("msg", "账户密码错误");
            return map;
        }


    }

    @RequestMapping("/loginUserInsert")
    @ResponseBody
    public Map registered(UserBean userBean) {
        Map<String, Object> map = new HashMap();
        try {
            if (userService.selectUserTable(userBean.getName()) != null) {
                map.put("msg", "用户" + userBean.getName() + "已存在");
                map.put("num", 0);
                System.out.println("用户" + userBean.getName() + "已存在");
                return map;
            } else {
                String id = UUID.randomUUID().toString().replace("-", "");
                userBean.setId(id);
                userService.save(userBean);
                map.put("msg", "注册成功");
                map.put("num", 1);
                System.out.println("新用户" + userBean.getName() + "注册成功");
                System.out.println(JSON.toJSONString(map));
                return map;
            }


        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "注册失败");
            map.put("num", 2);
            System.out.println("新用户注册失败");
            return map;
        }

    }


}

