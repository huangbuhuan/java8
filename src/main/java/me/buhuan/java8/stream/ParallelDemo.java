package me.buhuan.java8.stream;

import me.buhuan.java8.utils.UserUtils;

import java.util.stream.Collectors;

/**
 * 并行流不一定会比串行流高效，因为在创建并行流时需要额外的开销，它的性能还受编码方式和核数的影响。
 * 单核的时候没必要使用并行化，只有在数据量多，处理时间比较慢的时候使用
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/25下午10:27
 */
public class ParallelDemo {

    public static void main(String[] args) {
        // list调用parallelStream返回一个并行流
        UserUtils.getDefaultUserList()
                 .parallelStream()
                 .filter(user -> user.getAge() > 18)
                 .collect(Collectors.toList());
        // Stream流可以调用parallel方法就可以进行并行操作
        UserUtils.getUserStream()
                 .parallel()
                 .filter(user -> user.getAge() > 18)
                 .collect(Collectors.toList());
    }

}
