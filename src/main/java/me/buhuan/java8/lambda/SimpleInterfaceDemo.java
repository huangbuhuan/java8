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
        System.out.println("predicate: " + predicate.test(1));

        Consumer<Integer> consumer = x -> System.out.println("consumer: " + x);
        consumer.accept(1);

        Function<Integer, Integer> function = x -> x = x + 1;
        System.out.println("function: " + function.apply(1));

        Supplier<Integer> supplier = () -> 1;
        System.out.println("supplier: " + supplier.get());

        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        System.out.println("unaryOperator: " + unaryOperator.apply(1));

        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println("binaryOperator: " + binaryOperator.apply(1, 2));

        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + y + "";
        System.out.println("biFunction: " + biFunction.apply(1, 2));
    }
}
