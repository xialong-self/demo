package com.example.demo.aop;

import java.lang.annotation.*;

/**
 * @author 夏龙
 * @date 2020-12-01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NoneAuth {
}
