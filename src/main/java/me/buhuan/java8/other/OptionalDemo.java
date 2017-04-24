package me.buhuan.java8.other;

import me.buhuan.java8.model.User;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/24下午12:32
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<User> userOptional = Optional.of(User.of("hbh", 1, "hz"));
        // ifPresent判断是否为null, 不为空执行表达式
        userOptional.ifPresent(user -> System.out.println(user.getAge()));
        // isPresent判断是否为null
        System.out.println(userOptional.isPresent());
        // map执行map函数返回Optional对象
        System.out.println(userOptional.map(user -> user.getName().toUpperCase()).get());
    }

}
