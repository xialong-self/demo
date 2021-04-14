package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.MessageBean;
import com.example.demo.service.MessageService;
import com.example.demo.utils.DateTimeUtils;
import com.example.demo.utils.TokenUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author 夏龙
 * @date 2020-11-23
 */
@RestController
public class MassageController   {
    //将Service注入Web层
    final
    MessageService messageService;
    @Autowired
    public MassageController(MessageService messageService) {
        this.messageService = messageService;
    }

    Map<String,String> map = new HashMap();


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

    @RequestMapping(value = "/inertMessage", method = RequestMethod.POST)
    public Map addUser(MessageBean messageBean){
        Date date= DateTimeUtils.StringToDate(DateTimeUtils.getSystemDateTimeString(),"yyyy-MM-dd hh:mm:ss");
        Timestamp sqlDate = new Timestamp(date.getTime());
//        Integer id=UUID.randomUUID().toString().substring(32);
//        messageBean.setId(id);
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
    public String listMessage(MessageBean messageBean){
        List<MessageBean> messageBeanList=messageService.messageList();

        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("data",messageBeanList);
        return obj.toJSONString();

    }

    @RequestMapping("/deleteMessage")
    @ResponseBody
    public Map deleteMessage(MessageBean messageBean){


        return map;

    }

}
