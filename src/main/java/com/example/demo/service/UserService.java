package com.example.demo.service;


import com.example.demo.bean.UserBean;

import java.util.List;

/**
 * @author 夏龙
 * @date 2020-11-23
 */


public interface UserService {

    UserBean loginIn(String name, String password);

    int save(UserBean userBean);
    String selectUserTable(String name);
    List<UserBean> list();
//    UserBean update(UserBean userBean);

}
