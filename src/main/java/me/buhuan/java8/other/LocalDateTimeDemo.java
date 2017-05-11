package me.buhuan.java8.other;

import java.time.LocalDateTime;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/11下午11:23
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfYear());
        LocalDateTime last = LocalDateTime.parse("2017-05-11T23:25:58.700");
        System.out.println(last);
    }

}
