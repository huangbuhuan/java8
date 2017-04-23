package me.buhuan.java8.lambda;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/24上午12:48
 */
@FunctionalInterface
public interface FunctionInterface {

    void test();

    static void say() {
        System.out.println("hello");
    }

    default void play() {

    }
}
