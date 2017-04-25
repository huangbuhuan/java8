package me.buhuan.java8.stream;

import java.util.stream.Stream;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:17
 */
public class ReduceDemo {

    public static void main(String[] args) {
        int ages = Stream.of(1, 2, 34).reduce(0, (a, b) -> a + b);
        System.out.println(ages);
    }

}
