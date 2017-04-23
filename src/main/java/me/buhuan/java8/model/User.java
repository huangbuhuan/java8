package me.buhuan.java8.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/22上午1:27
 */
public class User {
    private String name;
    private Integer age;
    private String address;

    public static User of(String name, Integer age, String address) {
        User user = new User();
        user.name = name;
        user.age = age;
        user.address = address;
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
