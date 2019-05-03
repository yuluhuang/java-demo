package com.yuluhuang.demo.JSONTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ylh
 * @create 2018-04-09
 */
public class UserGroup {
    private String name;
    private List<Student> users = new ArrayList<Student>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getUsers() {
        return users;
    }

    public void setUsers(List<Student> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserGroup [name=" + name + ", users=" + users + "]";
    }
}
