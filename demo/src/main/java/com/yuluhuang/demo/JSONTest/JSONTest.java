package com.yuluhuang.demo.JSONTest;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author ylh
 * @create 2018-04-09
 */
public class JSONTest {
    @Test
    public void test1() {
        Student boy = new Student();
        boy.setName("bibi");
        boy.setAge(25);

        Student girl = new Student();
        girl.setName("lili");
        girl.setAge(11);

        UserGroup users = new UserGroup();
        users.setName("student");
        users.getUsers().add(boy);
        users.getUsers().add(girl);

        String jsonString = JSON.toJSONString(users);
        System.out.println("jsonString:" + jsonString);

        // JSON串转用户组对象
        UserGroup group2 = JSON.parseObject(jsonString, UserGroup.class);
        System.out.println("group2:" + group2);

        // 构建用户对象数组
        Student[] _users = new Student[2];
        _users[0] = boy;
        _users[1] = girl;
        // 用户对象数组转JSON串
        String jsonString2 = JSON.toJSONString(_users);
        System.out.println("jsonString2:" + jsonString2);
        // JSON串转用户对象列表
        List<Student> users2 = JSON.parseArray(jsonString2, Student.class);
        System.out.println("users2:" + users2);
    }
}
