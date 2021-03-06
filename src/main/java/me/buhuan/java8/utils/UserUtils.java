package me.buhuan.java8.utils;

import me.buhuan.java8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:41
 */
public class UserUtils {

    public static List<User> getDefaultUserList() {
        return Arrays.asList(
                User.of("小智", 18, "浙江"),
                User.of("小霞", 20, "上海"),
                User.of("小刚", 19, "江苏")
        );
    }

    public static Stream<User> getUserStream() {
        return getDefaultUserList().stream();
    }

    public static void println(List<User> users) {
        users.forEach(user -> System.out.println(user.getName() + ":" + user.getAge()));
    }

    public static void println(User user) {
        System.out.println(user.getName());
    }

}
