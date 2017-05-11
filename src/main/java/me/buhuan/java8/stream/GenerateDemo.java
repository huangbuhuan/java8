package me.buhuan.java8.stream;

import java.util.stream.Stream;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午9:49
 */
public class GenerateDemo {

    public static void main(String[] args) {
        // 使用iterate方法创建无限流， 有关联关系
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        // 使用generate方法创建无限流, 无关联关系
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
