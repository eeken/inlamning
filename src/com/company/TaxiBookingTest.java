package com.company;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TaxiBookingTest {

    @org.junit.jupiter.api.Test
    void addCar() {
        String input = "lexus\n2019\n2000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaxiBooking taxiBooking = new TaxiBooking();
        int size = taxiBooking.getAllCars().size();
        taxiBooking.addCar();
        int newSize = taxiBooking.getAllCars().size();
        assertEquals(newSize, size+1);
    }

}