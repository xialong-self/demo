package com.example.demo.utils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @author 夏龙
 * @date 2020-12-01
 */


public class TokenUse {
    //过期时间24小时
    private static final long overdeuTime = 30 * 60 * 1000;
    //私钥uuid生成，确定唯一性
    private static final String tokenSecRet = "fde35b32-0f47-46be-ae2a-49bcb7ed7d7f";

    /**
     * 生成token，用户退出后消失
     *
     * @param name
     * @param password
     * @return
     */
    public static String sign(String name, String password) {
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + overdeuTime);
            //token私钥加密
            Algorithm algorithm = Algorithm.HMAC256(tokenSecRet);
            //设置头部信息
            Map<String, Object> requestHender = new HashMap<>();
            requestHender.put("type", "JWT");
            requestHender.put("alg", "HS256");
            long date1=new Date().getTime();
            //返回带有用户信息的签名
            return JWT.create()
                    .withHeader(requestHender)
                    .withClaim("name", name)
                    .withClaim("password", password)
                    .withClaim("Time",date1)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 验证token是否正确
     *
     * @param token
     * @return
     */
    public static boolean tokenVerify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecRet);
            JWTVerifier verifier = JWT.require(algorithm).build();
            System.out.println(verifier+"token验证");
            //验证
            DecodedJWT decodedJWT = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取登陆用户token中的用户ID
     *
     * @param token
     * @return
     */
    public static String getUserID(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("name").toString();
    }
}
