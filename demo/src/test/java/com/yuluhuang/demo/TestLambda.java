/**
 * @Title
 * @Project java-Demo
 * @Package com.yuluhuang.Demo
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 11:45
 * @version
 */
package com.yuluhuang.demo;

import com.yuluhuang.demo.lambda.MyFun;
import com.yuluhuang.demo.lambda.MyFunction;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.PrintStream;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @author yoshikouamari
 * @Description
 * @date 2019-05-02 11:45
 */
public class TestLambda {

    class Em {
        private String name;

        private Integer age;

        public Em(Integer age) {
            this.age = age;
        }

        public Em(String name, Integer age) {
            this.name = name;
            this.age = age;
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
    }

    @org.junit.Test
    public void test() {
        List<Em> ems = Arrays.asList(
                new Em(1),
                new Em(1)
        );

        ems.stream()
                .filter((e) -> e.getName() == "1")
                .limit(2)
                .forEach(System.out::println);

        // 并行
        ems.parallelStream()
                .filter((e) -> e.getName() == "1")
                .limit(2)
                .forEach(System.out::println);


        ems.stream()
                .map(Em::getName)
                .forEach(System.out::print);
    }


    @org.junit.Test
    public void test1() {
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda" + num);
            }
        };
        r.run();
        System.out.println("--------------------------------");

        Runnable re = () -> System.out.println("Hello Lambda" + num);
        re.run();
    }


    @org.junit.Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("1234567890");
    }


    @org.junit.Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式借接口");
            return Integer.compare(x, y);
        };
    }

    @org.junit.Test
    public void test4() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
        Comparator<Integer> com2 = (x, y) -> Integer.compare(x, y);
    }

    @org.junit.Test
    public void test5() {

    }


    @org.junit.Test
    public void test6() {
        Integer num = operation(100, (x) -> x * x);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }


    /**
     * Function：接受一个参数，返回一个参数。
     * Consumer：接受一个参数，不返回参数。
     * Predicate：用于测试是否符合条件。
     */
    @org.junit.Test
    public void test7() {
        String name = "";
        String name1 = "12345";
        System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空" : inputStr));
        System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长" : inputStr));

    }

    public String validInput(String name, Function<String, String> function) {
        return function.apply(name);
    }


    @org.junit.Test
    public void test8() {
        String name = "";
        String name1 = "12345";
        validInput2(name, inputStr -> System.out.println(inputStr.isEmpty() ? "名字不能为空" : "111"));
        validInput2(name1, inputStr -> System.out.println(inputStr.length() > 3 ? "名字过长" : "222"));

    }

    public void validInput2(String name, Consumer<String> function) {
        function.accept(name);
    }


    public void test9() {
        String name = "";
        String name1 = "12345";
        System.out.println(validInput3(name, inputStr -> inputStr.isEmpty()));
        System.out.println(validInput3(name1, inputStr -> inputStr.length() > 3));

    }

    public boolean validInput3(String name, Predicate<String> function) {
        return function.test(name);
    }


    @org.junit.Test
    public void test10() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);


    }

    List<Em> ems = Arrays.asList(
            new Em(1),
            new Em(1)
    );

    @org.junit.Test
    public void test11() {
        Collections.sort(ems, (e1, e2) -> {
            return Integer.compare(e1.getAge(), e2.getAge());
        });
        for (Em em : ems) {
            System.out.println(em);
        }
    }


    @org.junit.Test
    public void test12() {
        Integer trimStr = strHandler(123, str -> str + 1);
        System.out.println(trimStr);
    }

    public Integer strHandler(Integer str, MyFun mf) {
        return mf.getValue(str);
    }


    @org.junit.Test
    public void test13() {
        op(100L, 200L, (x, y) -> x + y);
    }

    public void op(Long l1, Long l2, MyFunction<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }


    @org.junit.Test
    public void test14() {
        //简单的,只有一行
        Function<Integer, String> function1 = (x) -> "test result: " + x;

        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            return "after function1";
        };
//        System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(6));
    }

    /**
     * Consumer<T> : 消费型接口
     * void accept(T t)
     * <p>
     * Supplier<T> : 供给型接口
     * T get()
     * Function<T, R> : 函数型接口
     * R apply(T, t)
     * Predicate<T> : 断言型接口
     * boolean test(T t)
     */
    @org.junit.Test
    public void test15() {
        happy(1000, m -> System.out.println(m));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @org.junit.Test
    public void test16() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    @org.junit.Test
    public void test17() {
        String newStr = strHandler("sdasdfsa", (str) -> str.trim());
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // 方法引用： 若Lambda 体中的内容有方法已经实现了， 我们可以使用 方法引用
    // 语法格式
    // 对象::实例方法名
    // 类::静态方法名
    // 类::实例方法名
    @org.junit.Test
    public void test18() {
        PrintStream ps1 = System.out;
        Consumer<String> con = x -> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("sadfsdf");
    }


    @org.junit.Test
    public void test19() {
        Em em = new Em(1);
        Supplier<String> supplier = () -> em.getName();
        String string = supplier.get();
        System.out.print(string);

        Supplier<Integer> supplier2 = em::getAge;
        Integer num = supplier2.get();
        System.out.println(num);
    }


    @org.junit.Test
    public void test20() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator = Integer::compare;
    }

    @org.junit.Test
    public void test21() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
    }

    // 构造器引用
    // ClassName::new
//    @org.junit.Test
//    public void test22() {
//        Supplier<Em> sup = () -> new Em(1);
//        sup.get();
//
//        Supplier<Em> supplier = Em::new;
//        Em em = supplier.get();
//        System.out.println(em);
//    }

    @org.junit.Test
    public void test23() {
        Function<Integer, Em> fun = (x) -> new Em(x);

        Function<Integer, Em> fun2 = Em::new;
        Em em = fun2.apply(101);
        System.out.println(em);
    }

    // 数组引用
    @org.junit.Test
    public void Test24() {
        Function<Integer, String[]> fun = (x) -> new String[x];

        String[] strings = fun.apply(10);
        System.out.println(strings.length);

        Function<Integer, String[]> fun2 = String[]::new;
    }


    @org.junit.Test
    public void test25() {
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();

        Em[] ems = new Em[10];
        Stream<Em> stream = Arrays.stream(ems);

        Stream<String> stream1 = Stream.of("aa", "bb", "c");

        //
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2);
        stream2
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(() -> (int) (Math.random()))
                .limit(5)
                .forEach(System.out::println);
    }

//    List<Em> ems = Arrays.asList(
//            new Em(1),
//            new Em(2),
//            new Em(3)
//    );

    @Test
    public void test26() {
        Stream<Em> s = ems.stream()
                .filter((e) -> e.getAge() > 1);
        s.forEach(System.out::println);
    }

}
