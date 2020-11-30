package com.example.demo.service;


import com.example.demo.bean.UserBean;

/**
 * @author 夏龙
 * @date 2020-11-23
 */


public interface UserService {

    UserBean loginIn(String name, String password);

    int save(UserBean userBean);
    String selectUserTable(String name);
//    UserBean update(UserBean userBean);

}
