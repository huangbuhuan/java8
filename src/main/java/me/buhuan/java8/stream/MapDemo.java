package me.buhuan.java8.stream;

import me.buhuan.java8.utils.UserUtils;
import me.buhuan.java8.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午2:16
 */
public class MapDemo {

    public static void main(String[] args) {
        List<User> users = UserUtils.getDefaultUserList();
        List<Integer> ages = users.stream()
                                  .map(User::getAge)
                                  .collect(Collectors.toList());
        ages.forEach(age -> System.out.println(age));
    }

}
