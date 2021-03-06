## 高效Java 8编程

用来记录Java 8学习，以及常用API的使用。

![](https://img.shields.io/wercker/ci/wercker/docs.svg)
![](https://img.shields.io/badge/java%20support-8-green.svg)
![](https://img.shields.io/david/strongloop/express.svg)

## 目录:

- [函数式编程](#函数式编程)
- [Lambda表达式](#Lambda表达式)
	* [函数式接口](#函数式接口)
	* [Java 8中重要的函数式接口](#Java8中重要的函数式接口)
- [Stream流](#Stream流)
	* [collect方法](#collect方法)
	* [filter方法](#filter方法)
	* [map方法](#map方法)
	* [flatMap方法](#flatMap方法)
	* [max和min方法](#max和min方法)
	* [reduce方法](#reduce方法)
	* [创建无限流](#创建无限流)
	* [其他方法](#其他方法)
- [高效Java 8编程](#高效Java8编程)
- [其他](#其他)
	* [Optional](#Optional) 
	* [DateTime](#DateTime)	
- [参考链接](#参考链接) 	

<a name="函数式编程"></a>
## 函数式编程
函数式编程是一种编程范式，它的主要思想是把函数过程尽量写成一系列嵌套的函数调用。具有以下几个特点

* 函数是一等公民:函数和其他数据类型一样，可以赋值给其他变量，也可以作为参数，传递给另外一个函数，或者作为返回值返回。

* 没有副作用，不修改状态。

* 强调将计算过程分解成可复用的函数。
<a name="Lambda表达式"></a>

## Lambda表达式

>Lambda表达式没有名字，当它有参数列表、函数主体、返回类型，可能还有一个可以抛出的异常列表。

|使用案例|Lambda示例|
|---|---|
|布尔表达式|(List<String> list) -> list.isEmpty()|
|创建对象|() -> new User()|
|消费一个对象|(User user) -> {System.out.println(user.getName;)}|
|从一个对象中选择/抽取|(String s) -> s.length()|
|组合两个值|(int a, int b) -> a * b|
|比较两个对象|(User a1, User a2)|

<a name="函数式接口"></a>
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

<a name="Java8中重要的函数式接口"></a>
### Java8中重要的函数式接口

下面是Java 8中一些常用的函数式接口。

|接口名|参数|返回类型|示例|
|:--|:--|:--|:--|
|Predicate\<T>|\<T>|boolean|判断是否|
|Consumer\<T>|\<T>|void|输出一个值|
|Function\<T>|\<T>|R|获得Artist对象的名字|
|Supplier\<T>|None|T|工厂方法|
|UnaryOperator\<T>|T|T|逻辑非(!)|
|BinaryOperator\<T>|(T, T)|T|求两个数的乘积(*)|

简单的使用例子：

	Predicate<Integer> predicate = x -> x == 1;
	Consumer<Integer> consumer = x -> System.out.println(x);
	Function<Integer, Integer> function = x -> x = x + 1;
	Supplier<Integer> supplier = () -> 1;
	UnaryOperator<Integer> unaryOperator = x -> x + 1;
	BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;

<a name="Stream流"></a>
## Stream流

![UML关系图](./img/WX20170422-014241@2x.png)

Stream是一个借口继承了BaseStream接口，BaseStream接口继承了AutoCloseable接口。它只能被消费一次，如果想要继续使用，需要重新创建一个流。如下会抛出异常。
	
	List<String> strs = Arrays.asList("A", "B", "C");
	Stream<String> s = strs.stream();
	s.forEach(System.out::println);
	s.forEach(System.out::println);
	
### 内部迭代实现机制
外部迭代:首先调用Iterator方法，产生一个新的Iterator对象，进行控制迭代过程。

内部迭代:首先调用stream方法，它的作用和iterator()方法一样，不过它返回的是内部迭代中相应的接口Stream。这样做的好处就是在迭代时要进行多次操作时可以不用多次循环，只需要迭代一次就好了。
像filter这种不产生新集合的方法叫做[惰性求值](https://zh.wikipedia.org/wiki/%E6%83%B0%E6%80%A7%E6%B1%82%E5%80%BC)方法，像count这样最终会从Stream产生值的方法叫作及早求值方法。

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
<a name="collect方法"></a>

## 常用的方法

### collect方法
将Stream流转换为一个集合
	
	#输入
	Stream<String> stream = Stream.of("a", "b", "c");
	List<String> strs = stream.collect(Collectors.toList());
	strs.forEach(System.out::println);
	#输出
	a
	b
	c
	
<a name="filter方法"></a>
### filter方法
过滤掉流中不符合条件的元素
	
	#输入
	Stream<Integer> nums = Stream.of(18, 19 ,20);
	nums.filter(num -> num > 18).forEach(System.out::println);
	
	#输出
	c
<a name="map方法"></a>
### map方法
将流中的元素转换为另外一个元素。

	#输入
	Stream<Integer> nums = Stream.of(18, 19 ,20);
	map(num -> num + 100).forEach(System.out::println);
	
	#输出
	118
	119
	120
<a name="flatMap方法"></a>
### flatMap方法
将底层的元素全部抽出来放到一起，如下将List中的元素全部抽取出来，流中只包含Integer元素。

	List<Integer> nums1 = Arrays.asList(1, 2, 3);
	List<Integer> nums2 = Arrays.asList(4, 6);
	Stream.of(nums1, nums2).flatMap(num -> num.stream()).forEach(System.out::println);
<a name="reduce"></a>
### reduce方法
将Stream流中的数据聚合成一个数据
![图片来源](https://segmentfault.com/img/bVGyNp?w=1216&h=867)


	#输入
	int ages = Stream.of(1, 2, 34).reduce(0, (a, b) -> a + b);
	System.out.println(ages);
	
	#输出
	37

<a name="创建无限流"></a>
### 创建无限流
Stream的API提供了两个静态方法创建无限流：iterate和generate。由两个静态方法创建的流会根据给定的函数按需创建流一般会使用limit限制流的大小。iterate方法会对每个新生成的值都调用函数,generate方法不会对每个新生成的值应用函数.
	
	// 从0开始，生成10个偶数。
	Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	// 生成10个随机数。
	Stream.generate(Math::random). limit(10).forEach(System.out::println);

<a name="其他方法"></a>
### 其他方法
* skip：跳过指定个数的流。
* limit：返回不超过给定长度的流。
* max：找到最大的元素
* min：找到最小的元素
* findFirst：找到第一个匹配元素
* findAny：获取任意一个元素
* anyMatch：是否存在一个匹配元素
* noneMatch：是否全部不匹配
* allMatch：是否全部匹配
* sorted：排序
* distinct：去重

<a name="高效Java8编程"></a>
## 高效Java8编程


## 其他

### Optional
Optional是为了减少NullPointException，增加代码的可读性。Optional是一个final类型的类
	
	Optional<User> optUser = Optional.of(user);
	
* empty：返回一个空的Optional实例。
* filter：如果满足提交返回Optional对象，否则返回一个空的Optional对象。
* flatMap：如果值存在，就使用mapping函数调用，返回一个Optional对象，否则返回一个空对象。
* get：如果值存在返回用Optional封装返回，否则抛出NoSuchElementException异常
* ifPresent：如果值存在，就返回该方法的调用，否则什么也不做。
* isPresent：如果值存在，就返回true，否则返回false。
* map：如果值存在，就执行提供的mapping函数调用。
* of：如果值不存在就抛出异常，否则返回一个Optional封装的对象。
* ofNullable：如果值为空就返回一个空的Optional对象，否则调用of方法。
* orElse：如果值存在就返回该值，否则返回默认值。
* orElseGet：如果值存在就返回该值，否则返回一个函数接口生成的值。
* orElseThrow：如果值存在就返回该值，否则抛出一个接口生成的异常。

### DateTime

在Java 8 以前需要使用Date和SimpdateFormatter操作时间，而且都不是线程安全的，Date不仅包含日期还包含时间和毫秒数，使用起来非常的困难，而Java 8把日期分成了LocalDate和LocalTime，还有LocalDateTime。

使用LocalDate操作日期

	// 获取当前日期
    LocalDate now = LocalDate.now();

    // 用静态方法创建日期
    LocalDate date = LocalDate.of(2017, 5, 1);

    // 将String类型转换为日期类型.注：02不能写成2，否则会抛出DateTimeParseException
    LocalDate endOfFeb = LocalDate.parse("2017-02-28");

    // 获取这个月的第一天的日期
    now.with(TemporalAdjusters.firstDayOfMonth())

    // 获取这个月的最后一天
    now.with(TemporalAdjusters.lastDayOfMonth())

使用LocalTime操作时间

	// 获取当前时间
    LocalTime now = LocalTime.now();

    // 舍弃纳秒
    now.withNano(0);
    
    /*
     * 获取特定的时间
     * Localtime.MIN 00:00
     * Localtime.MIDNIGHT 00:00
     * Localtime.NOON 12:00
     * LocalTime.MAX 23:59:59.999999999
     */
    now.with(LocalTime.MIN);
    now.with(LocalTime.MIDNIGHT);
    now.with(LocalTime.NOON);
    now.with(LocalTime.MAX);
    
    // of可以传入四个参数
    LocalTime zero = LocalTime.of(23, 59, 59, 999_999_999);
    
    // parse方法可以转换的格式有 HH:mm:ss.nnnnnnnnn HH:mm:ss HH:mm
    LocalTime last = LocalTime.parse("23:59:59.999999999");
    
    // 也可以自定义转换格式
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime start = LocalTime.parse("00:00:00", formatter);

JDBC映射和新类型关联

	date -> LocalDate
	time -> LocalTime
	timestamp -> LocalDateTime

## 代码地址	
[https://github.com/huangbuhuan/java8](https://github.com/huangbuhuan/java8)

<a name="参考链接"></a>
## 参考链接


1. [函数式编程入门教程](http://www.ruanyifeng.com/blog/2017/02/fp-tutorial.html7)
2. [Java 8开发的4大顶级技巧](http://www.importnew.com/22417.html)
3. [Java 8 Optional: How to Use it](http://blog.jhades.org/java-8-how-to-use-optional/)
4. [Java 8 时间日期库的20个使用示例](http://www.codeceo.com/article/java-8-20-datetime.html)
5. [如何在Java 8中愉快地处理日期和时间](http://www.liaoxuefeng.com/article/00141939241051502ada88137694b62bfe844cd79e12c32000)
5. [Java 8学习资料汇总](http://ifeve.com/java8-learning-resources/)
6. [Java 8中Stream详解](https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/)
7. [Java 8 API在线版地址](http://docs.oracle.com/javase/8/docs/api/index.html)
8. [《Java8实战》](https://book.douban.com/subject/25912747/)
9. [《Java8函数式编程》](https://book.douban.com/subject/26346017/)
10. [《写给大忙人看的Java SE 8》](https://book.douban.com/subject/26274206/comments/hot?p=1)

