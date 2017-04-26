package me.buhuan.java8.dsl;

import java.util.Objects;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/26下午8:29
 */
public final class Expect {

    public BoundExpectation that(Object value) {
        throw new BoundExpectation();
    }

}
