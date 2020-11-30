package com.example.demo.mapper;

import com.example.demo.bean.UserBean;
import org.springframework.stereotype.Component;


/**
 * @author 夏龙
 * @date 2020-11-23
 */


@Component
public interface UserMapper {

    UserBean getInfo(String name, String password);
    int saveUser(UserBean userBean);
    String selectUser(String name);
//    UserBean modifyUser(UserBean userBean);


}