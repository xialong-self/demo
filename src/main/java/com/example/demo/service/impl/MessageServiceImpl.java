package com.example.demo.service.impl;

import com.example.demo.bean.MessageBean;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.MessageService;
import com.example.demo.utils.DateTimeUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @author 夏龙
 * @date 2020-11-23
 */
@Service
public class MessageServiceImpl implements MessageService {
    //将Dao注入Service层
    final
    MessageMapper messageMapper;

    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }


    @Override
    public MessageBean getMessage(int id) {
        return messageMapper.getMessage(id);
    }



    @Override
    public void save(MessageBean messageBean) {
         messageMapper.save(messageBean);
    }

    @Override
    public List<MessageBean> messageList() {
        return messageMapper.listMessage();
    }
}
