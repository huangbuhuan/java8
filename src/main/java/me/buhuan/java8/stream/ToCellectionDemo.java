package me.buhuan.java8.stream;

import me.buhuan.java8.model.User;
import me.buhuan.java8.utils.UserUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/25上午12:22
 */
public class ToCellectionDemo {

    public static void main(String[] args) {
        // 返回一个map 包含false的list，和true的list
        Map<Boolean, List<User>> userMap = UserUtils.getUserStream()
                                                    .collect(partitioningBy(user -> user.getAge() > 0));
        // 数据分组和SQL中的group by 类似
        Map<String, List<User>> userList = UserUtils.getUserStream().collect(groupingBy(user -> user.getName()));

        // joining操作字符串, 第一个参数表示以什么分隔，第二个参数表示以什么开始，第三个参数表示以什么结尾。
        String result = UserUtils.getUserStream().map(User::getName).collect(Collectors.joining(","));
        String result2 = UserUtils.getUserStream().map(User::getName).collect(Collectors.joining(",", "(", ")"));
        System.out.println(result + "\n" + result2);

        // 生成一对多的关系
        Map<String, List<Integer>> users = UserUtils.getUserStream()
                                                    .collect(groupingBy(User::getName, mapping(User::getAge, toList())));
        users.forEach((name, ages) -> System.out.println(name + ages));
    }

}
