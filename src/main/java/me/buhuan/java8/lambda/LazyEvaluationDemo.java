package me.buhuan.java8.lambda;

import me.buhuan.java8.utils.UserUtils;
import me.buhuan.java8.model.User;

import java.util.List;

/**
 * Java 8 惰性求值例子
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/23上午12:33
 */
public class LazyEvaluationDemo {

    public static void main(String[] args) {
        List<User> users = UserUtils.getDefaultUserList();
        users.stream()
             .filter(user -> {
                 System.out.println(user.getName());
                 return user.getAge() > 20;
             });
        System.out.println("------------");
        users.stream()
             .filter(user -> {
                 System.out.println(user.getName());
                 return user.getAge() > 20;
             }).count();
    }

}
