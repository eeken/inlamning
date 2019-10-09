package com.company;

import java.io.Serializable;
import java.util.Comparator;

public class Customer extends Person implements Comparable<Customer>, Serializable {

    String destination;
    float price;
    // String name;

    public Customer(String name, String destination, float price){
        super(name);
        this.destination = destination;
        this.price = price;
    }

    public String toString(){

        return ("Name: " + super.getName()) + ", Destination: " + destination;
    }

    public int compareTo(Customer customer){
        return getName().compareTo(customer.getName());
    }

}
