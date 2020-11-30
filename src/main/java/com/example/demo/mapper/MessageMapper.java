package com.example.demo.mapper;

import com.example.demo.bean.MessageBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 夏龙
 * @date 2020-11-23
 */
@Component
public interface MessageMapper {
    MessageBean getMessage(int id);

    void save(MessageBean messageBean);
}
