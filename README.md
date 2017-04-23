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

## 函数式编程

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

	函数式接口就是仅仅声明了一个抽象方法的接口，不过函数式接口可以包含默认方法和静态方法。

### Java 8中自带的一些常用的函数式接口

* Predicate\<T>
* Function\<T>
* Supplier\<T>
* Consumer\<T>
* BinaryOperator/<T>


## Stream流

![UML关系图](./img/WX20170422-014241@2x.png)

Stream是一个借口继承了BaseStream接口，BaseStream接口继承了AutoCloseable接口。
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
