package me.buhuan.java8.stream;

import me.buhuan.java8.UserUtils;
import me.buhuan.java8.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream流中的filter方法例子
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:17
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<User> users = UserUtils.getDefaultUserList()
                                    .stream()
                                    .filter(user -> user.getAge() > 0)
                                    .collect(Collectors.toList());
        UserUtils.println(users);
    }
}
