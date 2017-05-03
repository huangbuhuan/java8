package me.buhuan.java8.other;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午6:34
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 用静态方法创建日期
        LocalDate date = LocalDate.of(2017, 5, 1);
        System.out.println(date);

        // 将String类型转换为日期类型.注：02不能写成2，否则会抛出DateTimeParseException
        LocalDate endOfFeb = LocalDate.parse("2017-02-28");
        System.out.println(endOfFeb);

        // 获取这个月的第一天的日期
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));

        // 获取这个月的最后一天
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
    }
}
