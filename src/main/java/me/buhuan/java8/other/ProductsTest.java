package me.buhuan.java8.other;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/3下午9:18
 */
public class ProductsTest {

    @Product(value = "a")
    @Product(value = "b")
    public void test() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Product[] products = ProductsTest.class.getMethod("test").getAnnotationsByType(Product.class);
        for (Product product : products) {
            System.out.println(product.value());
        }
    }
}
