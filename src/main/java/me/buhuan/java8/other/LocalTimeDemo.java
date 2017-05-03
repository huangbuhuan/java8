package me.buhuan.java8.other;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午6:40
 */
public class LocalTimeDemo {

    public static void main(String[] args) {
        // 获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println(now);
        // 舍弃纳秒
        System.out.println(now.withNano(0));
        /*
         * Localtime.MIN 00:00
         * Localtime.MIDNIGHT 00:00
         * Localtime.NOON 12:00
         * LocalTime.MAX 23:59:59.999999999
         */
        System.out.println(now.with(LocalTime.MIN));
        System.out.println(now.with(LocalTime.MIDNIGHT));
        System.out.println(now.with(LocalTime.NOON));
        System.out.println(now.with(LocalTime.MAX));
        // of可以传入四个参数
        LocalTime zero = LocalTime.of(23, 59, 59, 999_999_999);
        System.out.println(zero);
        // parse方法可以转换的格式有 HH:mm:ss.nnnnnnnnn HH:mm:ss HH:mm
        LocalTime last = LocalTime.parse("23:59:59.999999999");
        System.out.println(last);
        // 也可以自定义转换格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime start = LocalTime.parse("00:00:00", formatter);
        System.out.println(start);
    }

}
