package me.buhuan.java8.lambda;

import me.buhuan.java8.model.User;
import me.buhuan.java8.utils.UserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/12上午1:05
 */
public class FunctionRerenceDemo {

    public static void main(String[] args) {
        // 第一种方法引用
        long objectCount = UserUtils.getUserStream().filter(Objects::nonNull).count();
        System.out.println(objectCount);
        // 第二种方法引用
        long strCount = Stream.of("a", "b", "c").map(String::length).count();
        System.out.println(strCount);
        // 第三种方法引用
        List<String> output = new ArrayList<>();
        List<String> input = Arrays.asList("a", "b", "c");
        input.forEach(output::add);
        output.forEach(System.out::println);

        // 构造函数引用
        Supplier<String> stringSupplier = String::new;
        String string = stringSupplier.get();
        System.out.println(string);
        Function<String, String> stringFunction = String::new;
        String string2 = stringFunction.apply("a");
        System.out.println(string2);
    }

}
