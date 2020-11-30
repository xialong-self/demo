package com.example.demo.service;

import com.example.demo.bean.MessageBean;


/**
 * @author 夏龙
 * @date 2020-11-23
 */
public interface MessageService{
    MessageBean getMessage(int id);
    void save(MessageBean messageBean);
}
