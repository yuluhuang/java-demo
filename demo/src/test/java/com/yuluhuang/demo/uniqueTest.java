package com.yuluhuang.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ylh
 * @create 2018-05-14
 */
public class uniqueTest {
    class Employee {
        private String name;
        private Integer age;

        public Employee(String name, Integer age) {
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

        @Override
        public String toString() {
            return super.toString();
        }
    }

    @Test
    public void test1() {
        List<String> test1 = new ArrayList<>();
        test1.add("1");
        test1.add("2");
        test1.add("1");
        System.out.println(test1); // 1,2,1
        HashSet set = new HashSet(test1);
        // 保持原有顺序
        // Set<String> set = new LinkedHashSet<>();
        set.addAll(test1);
        System.out.println(set); // 1,2

    }

    @Test
    public void test3() {
        List<String> test1 = new ArrayList<>();
        test1.add("1");
        test1.add("2");
        test1.add("1");
        List<String> unique = test1.stream().distinct().collect(Collectors.toList());
        for (String e :
                unique) {
            System.out.println(e); // 1,2
        }
    }

    @Test
    public void test2() {
        List<Employee> test1 = new ArrayList<>();
        test1.add(new Employee("aa", 11));
        test1.add(new Employee("bb", 22));
        test1.add(new Employee("aa", 11));
        for (Employee e :
                test1) {
            System.out.println(e.getName()); // aa, bb, aa
        }


        Set<Employee> set = new LinkedHashSet<>();
        set.addAll(test1);
        for (Employee e :
                set) {
            System.out.println(e.getName()); // aa, bb, aa
        }


    }

    @Test
    public void test4() {
        // 根据某个属性去重
        List<Employee> test1 = new ArrayList<>();
        test1.add(new Employee("aa", 11));
        test1.add(new Employee("bb", 22));
        test1.add(new Employee("aa", 11));
        Set<Employee> employees = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));
        employees.addAll(test1);
        for (Employee e :
                employees) {
            System.out.println(e.getName()); // aa,bb
        }
    }


    @Test
    public void test5() {
        // 根据某个属性去重
        List<Employee> test1 = new ArrayList<>();
        test1.add(new Employee("aa", 11));
        test1.add(new Employee("bb", 22));
        test1.add(new Employee("aa", 11));
//        Set<Employee> employees = test1.stream().collect(collectingAndThen(
//                toCollection(() -> new TreeSet<>(comparingInt(Employee::getAge))), ArrayList::new));
    }

    @Test
    public void test6() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (list.toString().indexOf(array[i]) == -1) {
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }

    @Test
    public void test7() {
        Integer[] array = {1, 2, 1};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (list.indexOf(array[i]) == -1) {
                list.add(array[i]);
            }
        }
        Integer[] arrayResult = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arrayResult));
    }
}
