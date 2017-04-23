package me.buhuan.java8.stream;

import me.buhuan.java8.utils.UserUtils;
import me.buhuan.java8.model.User;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:40
 */
public class MaxAndMinDemo {

    public static void main(String[] args) {
        User max = createUserStream().max(Comparator.comparing(User::getAge)).get();
        User min = createUserStream().min(Comparator.comparing(User::getAge)).get();
        UserUtils.println(max);
        UserUtils.println(min);
    }

    private static Stream<User> createUserStream() {
        return UserUtils.getDefaultUserList().stream();
    }

}
