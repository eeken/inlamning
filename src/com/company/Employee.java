package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private String workArea;
    private String name;

    Employee(String name, String workArea){
        super(name);
        this.workArea = workArea;
    }

    public String getWorkArea() {
        return workArea;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + ", Workarea: " + workArea;
    }
}
