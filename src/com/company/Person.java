package com.company;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String toString();

}
