package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.service.UserService;
import com.example.demo.utils.TokenUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 夏龙
 * @date 2020-12-02
 */
@Controller
public class TokenController {
    //将Service注入Web层
    final
    UserService userService;

    Map map = new HashMap();
    @Autowired
    public TokenController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/tokenMessage", method = RequestMethod.GET)
    @ResponseBody
    public Map token(String name, String password) {
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) {
            map.put("token", TokenUse.sign(userBean.getName(), userBean.getPassword()));
            map.put("code", 0);
            System.out.println("账户密码正确，生成token返回给前台:" + map.get("token"));
            return map;

        } else {
            map.put("code", 1);
            map.put("msg", "账户密码错误");
            System.out.println("账户密码错误，token生成失败");
            return map;
        }


    }
}
