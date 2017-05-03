package me.buhuan.java8.other;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午9:18
 */
public class ProductsTest {

    @Products(value = {
        @Product(value = "a"), @Product(value = "b")
    })
    public void test() {

    }
}
