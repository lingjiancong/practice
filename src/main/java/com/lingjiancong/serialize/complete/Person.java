package com.lingjiancong.serialize.complete;

import java.io.Serializable;

/**
 * @author lingjiancong
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String format = "name = %s, age = %d";
        return String.format(format, this.name, this.age);
    }
}
