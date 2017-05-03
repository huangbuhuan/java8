package me.buhuan.java8.other;

import java.lang.annotation.*;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午9:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Products {
    Product[] value();
}
