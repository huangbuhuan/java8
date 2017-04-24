# Java 8指南

## 目录:

- [函数式编程](#函数式编程)
- [Lambda表达式](#Lambda表达式)
- [Stream流](#Stream流)
- [高效Java 8编程](#高效Java8编程)
- [超越Java 8](#超越Java8)
- [其他](#其他)
	* [Optional](#Optional) 
	* [DateTime](#DateTime)	
- [参考链接](#参考链接) 	

<a name="函数式编程"/>
## 函数式编程

<a name="Lambda表达式"/>
## Lambda表达式

>Lambda表达式没有名字，当它有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表。

|使用案例|Lambda示例|
|---|---|
|布尔表达式|(List<String> list) -> list.isEmpty()|
|创建对象|() -> new User()|
|消费一个对象|(User user) -> {System.out.println(user.getName;)}|
|从一个对象中选择/抽取|(String s) -> s.langth()|
|组合两个值|(int a, int b) -> a * b|
|比较两个对象|(User a1, User a2)|

### 函数式接口

函数式接口就是仅仅声明了一个抽象方法的接口，不过函数式接口可以包含默认方法和静态方法。如下：
	
	@FunctionalInterface
	public interface FunctionInterfaceDemo {
	
	    void test();
	
	    static void say() {
	        System.out.println("hello");
	    }
	
	    default void play() {
	
	    }
	}

### Java 8中重要的函数式接口

|接口名|参数|返回类型|示例|
|:--|:--|:--|:--|
|Predicate\<T>|\<T>|boolean|判断是否|
|Concumer\<T>|\<T>|void|输出一个值|
|Function\<T>|\<T>|R|获得Artist对象的名字|
|Supplier\<T>|None|T|工厂方法|
|UnaryOperator\<T>|T|T|逻辑非(!)|
|BinaryOperator\<T>|(T, T)|T|求两个数的乘积(*)|


## Stream流

![UML关系图](./img/WX20170422-014241@2x.png)

Stream是一个借口继承了BaseStream接口，BaseStream接口继承了AutoCloseable接口。


### 内部迭代实现机制
外部迭代:首先调用Iterator方法，产生一个新的Iterator对象，进行控制迭代过程。

内部迭代:首先调用stream方法，它的作用和iterator()方法一样，不过它返回的是内部迭代中相应的接口Stream。这样做的好处就是在迭代时要进行多次操作时可以不用多次循环，只需要迭代一次就好了。
像filter这种不产生新集合的方法叫做惰性求值方法，像count这样最终会从Stream产生值的方法叫作及早求值方法。

例子：

	User jack = User.of("Jack", 21, "杭州");
	User rose = User.of("Rose", 18, "杭州");
	List<User> users = Arrays.asList(jack, rose);
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

输出：
![](./img/WX20170423-004514@2x.png)
结论：只有在需要的时候进行计算可以更好的提示效率
### collect方法
### filter方法
### map方法
### flatMap方法
### max和min方法
### reduce方法
## 高效Java8编程

## 超越Java8

## 其他

### Optional


### DateTime

## 参考链接



1. [Java 8开发的4大顶级技巧](http://www.importnew.com/22417.html)
2. [Java 8 Optional: How to Use it](http://blog.jhades.org/java-8-how-to-use-optional/)
3. [Java8学习资料汇总](http://ifeve.com/java8-learning-resources/)
4. [《Java8实战》](https://book.douban.com/subject/25912747/)
5. [《Java8函数式编程》](https://book.douban.com/subject/26346017/)
6. [《写给大忙人看的Java SE 8》](https://book.douban.com/subject/26274206/comments/hot?p=1)
