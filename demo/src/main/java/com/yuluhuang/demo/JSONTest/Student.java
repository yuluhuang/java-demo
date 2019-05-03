package com.yuluhuang.demo.JSONTest;

/**
 * @author ylh
 * @create 2018-04-09
 */
public class Student {
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 住址
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address="
                + address + "]";
    }

}
