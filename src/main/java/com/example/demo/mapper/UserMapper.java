package com.example.demo.mapper;

import com.example.demo.bean.UserBean;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author 夏龙
 * @date 2020-11-23
 */


@Component
public interface UserMapper {

    UserBean getInfo(String name, String password);
    int saveUser(UserBean userBean);
    String selectUser(String name);
    List<UserBean> userList();
//    UserBean modifyUser(UserBean userBean);


}