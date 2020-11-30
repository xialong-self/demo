package com.example.demo.service.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
/**
 * @author 夏龙
 * @date 2020-11-23
 */


@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserBean loginIn(String name, String password) {

        return userMapper.getInfo(name,password);
    }

    @Override
    public int save(UserBean userBean) {
       return   userMapper.saveUser(userBean);
    }

    @Override
    public String selectUserTable(String name) {

       return userMapper.selectUser(name);
    }

//    @Override
//    public UserBean update(UserBean userBean) {
//        return userMapper.modifyUser(userBean);
//    }
}
