package com.example.demo.controller;

import com.example.demo.bean.MessageBean;
import com.example.demo.service.MessageService;
import com.example.demo.utils.BaseController;
import com.example.demo.utils.DateTimeUtils;
import com.example.demo.utils.UniqId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 夏龙
 * @date 2020-11-23
 */
@RestController
public class MassageController extends BaseController {
    //将Service注入Web层
    final
    MessageService messageService;
    @Autowired
    public MassageController(MessageService messageService) {
        this.messageService = messageService;
    }

    Map<String,Object> map = new HashMap();

    @RequestMapping("/getMessage")
    public Map<String,String> leave(int id){
        MessageBean messageBean = messageService.getMessage(id);
            //map集合用来存放返回值
            Map<String,String> map = new HashMap();
            if(messageBean != null) {
                map.put("message",messageBean.getMessage());
            }else {
                map.put("message","提交失败");
            }
            return map;

    }

    @RequestMapping("/inertMessage")
    @ResponseBody
    public Map addUser(MessageBean messageBean){
        Date date= DateTimeUtils.StringToDate(DateTimeUtils.getSystemDateTimeString(),"yyyy-MM-dd hh:mm:ss");
        Timestamp sqlDate = new Timestamp(date.getTime());
        String id=UUID.randomUUID().toString().substring(32);
        messageBean.setId(id);
        messageBean.setDate(sqlDate);

        try {
            messageService.save(messageBean);
            map.put("msg","信息保存成功");
            System.out.println("Message数据上传成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","信息保存失败");
            System.out.println("Message数据上传成功");
            return map;
        }
    }

    @RequestMapping("/listMessage")
    @ResponseBody
    public Map listMessage(MessageBean messageBean){


            return map;

    }

    @RequestMapping("/deleteMessage")
    @ResponseBody
    public Map deleteMessage(MessageBean messageBean){


        return map;

    }

}
