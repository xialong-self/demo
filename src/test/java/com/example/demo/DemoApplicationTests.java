package com.example.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.bean.MessageBean;
import com.example.demo.bean.UserBean;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import com.example.demo.utils.DateTimeUtils;
import com.example.demo.utils.TokenUse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Test
    public void token(){
        String token = TokenUse.sign("夏龙","1451122318");
        //这是生成的token
        System.out.println(token);
        //这里验证token
        boolean bo= TokenUse.tokenVerify("eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJwYXNzd29yZCI6IjE0NTExMjIzMTgiLCJuYW1lIjoi5aSP6b6ZIiwiVGltZSI6MTYwNjkwMjI4OTczNSwiZXhwIjoxNjA2OTA0MDg5fQ.Pz3mviHBfqj_6J5OM6aabaBueB_SsdeeviuXwIHXpos");
        System.out.println(bo);
//        try {
//            final String tokenSecRet = "fde35b32-0f47-46be-ae2a-49bcb7ed7d7f";
//            Algorithm algorithm = Algorithm.HMAC256(tokenSecRet);
//            JWTVerifier verifier = JWT.require(algorithm).build();
//            System.out.println(verifier);
//            //验证
//            DecodedJWT decodedJWT = verifier.verify("token");
//            System.out.println(decodedJWT);
//        } catch (Exception e) {
//
//        }
    }

    @Test
    public void userList(){
        List<UserBean> list=userService.list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        
    }

    @Test
    public void userInsert(){

//        UserBean userBean= new UserBean("123456xxxxxxxx4s878","夏龙","145112","玩游戏","男","2020-11-26","打球","1451122318@qq.com","大家好");
//        userService.save(userBean);
        if(userService.selectUserTable("lfh")!=null){
            System.out.println("不为空");
        }else{

        System.out.println("为空");}
    }


//    @Test
//    public void save(){
//        Date date= DateTimeUtils.StringToDate(DateTimeUtils.getSystemDateTimeString(),"yyyy-MM-dd HH:mm:ss");
//        Timestamp sqlDate = new Timestamp(date.getTime());
//        MessageBean messageBean= new MessageBean("14","111",sqlDate);
//                messageService.save(messageBean);
//    }

    @Test
    public void leave(){
        MessageBean messageBean= messageService.getMessage(1);
        System.out.println(messageBean.getMessage());

    }


    @Test
    public void tokenx()   {
        String token="eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJwYXNzd29yZCI6IjAxMiIsIm5hbWUiOiLlpI_pvpkiLCJUaW1lIjoxNjE1NDMyNjY4MDY3LCJleHAiOjE2MTU0MzQ0Njh9.0w2FquQJC7EqZXQjivNHQcFFvBxTq22Kq7n-mxd0qEQ";

        System.out.println(TokenUse.tokenVerify(token));

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
