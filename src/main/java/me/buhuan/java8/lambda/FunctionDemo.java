package me.buhuan.java8.lambda;

import java.util.function.Function;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/30上午11:06
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> f1 = x -> x * x;
        Function<Integer, Integer> f2 = x -> x + 1;
        Function<Integer, Integer> reuslt = f1.andThen(f2);
        System.out.println(reuslt.apply(2));

        modify(1, f2);
    }

    public static void modify(Integer input, Function<Integer, Integer> f1) {
        System.out.println(f1.apply(input));
    }

}
