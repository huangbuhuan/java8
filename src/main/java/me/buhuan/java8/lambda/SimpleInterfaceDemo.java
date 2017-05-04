package me.buhuan.java8.lambda;

import java.util.function.*;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/4上午8:56
 */
public class SimpleInterfaceDemo {

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x == 1;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Function<Integer, Integer> function = x -> x = x + 1;
        Supplier<Integer> supplier = () -> 1;
        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + y + "";
    }
}
