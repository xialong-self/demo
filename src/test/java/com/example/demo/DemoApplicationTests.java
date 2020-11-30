package com.example.demo;

import com.example.demo.bean.MessageBean;
import com.example.demo.bean.UserBean;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import com.example.demo.utils.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Test
    public void userInsert(){

//        UserBean userBean= new UserBean("123456xxxxxxxx4s878","夏龙","145112","玩游戏","男","2020-11-26","打球","1451122318@qq.com","大家好");
//        userService.save(userBean);
        if(userService.selectUserTable("lfh")!=null){
            System.out.println("不为空");
        }else{

        System.out.println("为空");}
    }


    @Test
    public void save(){
        Date date= DateTimeUtils.StringToDate(DateTimeUtils.getSystemDateTimeString(),"yyyy-MM-dd HH:mm:ss");
        Timestamp sqlDate = new Timestamp(date.getTime());
        MessageBean messageBean= new MessageBean("14","111",sqlDate);
                messageService.save(messageBean);
    }

    @Test
    public void leave(){
        MessageBean messageBean= messageService.getMessage(1);
        System.out.println(messageBean.getMessage());

    }


    @Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("a","a");

        if(userBean==null){
        System.out.println("数据库没有此条记录");}
        else {
            System.out.println("该用户ID为："+userBean.getId());
            System.out.println("该用户名为："+userBean.getName());
        }

    }


}
