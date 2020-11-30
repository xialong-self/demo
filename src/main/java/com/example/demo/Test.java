package com.example.demo;



import com.example.demo.utils.DateTimeUtils;

import java.util.UUID;


/**
 * @author 夏龙
 * @date 2020-11-25
 */
public class Test {



    public static void main(String[] args) {
        String id = UUID.randomUUID().toString().substring(32);
        System.out.println(id);
    }
}
