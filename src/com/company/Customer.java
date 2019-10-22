package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 *  <p>The Customer class contains a constructor to create a customer and also some return functions.</p>
 *
 *  @author  Ola Wiebe
 *  @version 1.0
 *  @since   20191021
 */
public class Customer extends Person implements Comparable<Customer>, Serializable {

    String destination;
    float price;
    // String name;

    /**
     * Constructor for Customer, runs when creating a customer.
     * @param name Name on customer
     * @param destination Destination for customer
     * @param price Price for the fare
     */
    public Customer(String name, String destination, float price){
        super(name);
        this.destination = destination;
        this.price = price;
    }

    /**
     * Make the customer object to a String
     * @return a String that describes the customer
     */
    public String toString(){
        return ("Name: " + super.getName()) + ", Destination: " + destination;
    }

    /**
     * Sorts the list in alphabetic order on name
     * @param customer  customer in list
     * @return Sorted list
     */
    public int compareTo(Customer customer){
        return getName().compareTo(customer.getName());
    }

}
