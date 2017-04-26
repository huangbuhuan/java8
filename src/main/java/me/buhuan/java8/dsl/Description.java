package me.buhuan.java8.dsl;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/4/26下午8:26
 */
public class Description {

    private String name;

    public Description(String name) {
        this.name = name;
    }

    public static void describe(String name, Suite behavior) {
        Description description = new Description("");
        behavior.specifySuite(description);
    }

    public void should(String desciption, Specification specification) {
        try {
            Expect expect = new Expect();
            specification.secifyBehaviour(expect);
        } catch (AssertionError error) {

        } catch (Throwable throwable) {
            
        }
    }

}
