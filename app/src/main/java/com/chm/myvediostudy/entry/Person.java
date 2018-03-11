package com.chm.myvediostudy.entry;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xiaobailong24 on 2017/9/6.
 * Dagger Person
 */

public class Person {
    private String name;
    private int age;

    @Inject
    public Person(String name, int age) {
        Log.e("TAG", "Constractor");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
