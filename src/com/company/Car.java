package com.company;

public class Car {

    String brand;
    int year;
    int price;

    Car(String brand, int year, int price){
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}
