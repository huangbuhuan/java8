package me.buhuan.java8.lambda;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/12下午3:46
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {
        FunctionInterface.say();
        FunctionInterface functionInterface = () -> System.out.println("这是一个函数式接口");
        functionInterface.test();
        functionInterface.play();
    }

}
