package com.simon.study.database;

import org.litepal.crud.LitePalSupport;

/**
 * created by simon
 * date 2018/7/18
 * version code 1.0
 * description:
 */
public class Person extends LitePalSupport {

    private String name;
    private int age;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
