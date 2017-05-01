package me.buhuan.java8.stream;

import me.buhuan.java8.utils.UserUtils;
import me.buhuan.java8.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流的cellect方法例子
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:18
 */
public class CollectDemo {

    public static void main(String[] args) {
        List<User> users = UserUtils.getDefaultUserList()
                                    .stream()
                                    .collect(Collectors.toList());
        UserUtils.println(users);
        Stream<String> stream = Stream.of("a", "b");
        List<String> strings = stream.collect(Collectors.toList());
        strings.forEach(System.out::println);
    }

}
