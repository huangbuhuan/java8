package me.buhuan.java8.stream;

import me.buhuan.java8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流中的flatMap例子
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:16
 */
public class FlatMapDemo {

    public static void main(String[] args) {
        List<User> users1 = Arrays.asList(User.of("", 1, ""), User.of("", 2, ""));
        List<User> users2 = Arrays.asList(User.of("", 3, ""), User.of("", 4, ""));
        List<User> userList = Stream.of(users1, users2)
                                    .flatMap(users -> users.stream())
                                    .collect(Collectors.toList());
        userList.forEach(user -> System.out.println(user.getAge()));

        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 6);
        Stream.of(nums1, nums2).flatMap(num -> num.stream()).forEach(System.out::println);
    }

}
