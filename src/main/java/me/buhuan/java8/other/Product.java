package me.buhuan.java8.other;

import java.lang.annotation.*;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午9:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Products.class)
public @interface Product {
    String value();
}
