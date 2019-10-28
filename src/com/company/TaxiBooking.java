package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Lunda Taxi</h1>
 * The TaxiBooking Program lets you book fares on a taxi system. You can also add employees and many other functions as well.
 * <p>
 *
 *
 *
 * @author  Ola Wiebe
 * @version 1.0
 * @since   20191021
 */

public class TaxiBooking implements Serializable {

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    FileUtils objectIO = new FileUtils();

    public void showMainMenu(){

        Scanner input = new Scanner(System.in);

        String menuChoice;

        do {
            System.out.println("--------------------------      .---.\n" +
                    "Welcome to Lunda Taxi!     .----'   '--.\n" +
                    "-------------------------- '-()-----()-'\n" +
                    "1. Add new taxi customer \n" +
                    "2. Add new employee \n" +
                    "3. Add new car \n" +
                    "4. Remove taxi customer \n" +
                    "5. Show all taxi customers \n" +
                    "6. Show all taxi employees \n" +
                    "7. Show all cars in system \n" +
                    "8. Show taxi customer \n" +
                    "9. Help \n" +
                    "10. Exit \n");
            menuChoice = input.nextLine();

            switch(menuChoice){
                case "1":
                    addCustomer();
                break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    addCar();
                    break;
                case "4":
                    removeCustomer();
                    break;
                case "5":
                    showAllCustomers();
                    break;
                case "6":
                    showAllEmployees();
                    break;
                case "7":
                    showAllCars();
                    break;
                case "8":
                    showCustomer();
                    break;
                case "9":
                        do {
                            System.out.println("1. Info about program \n" +
                                    "2. Back to main menu.");

                            menuChoice = input.nextLine();

                            switch (menuChoice) {
                                case "1":
                                    info();
                                    break;

                            }
                        } while (!menuChoice.equals("2"));

            }
        } while (!menuChoice.equals("10"));
    }

    public void addCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customers name: ");
        String name = input.nextLine();
        System.out.println("Enter customers destination: ");
        String destination = input.nextLine();
        System.out.println("Enter customers price: ");
        float price = input.nextFloat();

        Customer customer = new Customer(name, destination, price);
        customers.add(customer);
        System.out.println("Do you want to save customer information on file? (Y/N)");
        if(input.next().equalsIgnoreCase("Y")){
            objectIO.WriteObjectToFile("customerlist.txt", customers);
        }
    }

    public void removeCustomer(){
        int i = 0;
        Scanner input = new Scanner(System.in);
        if(customers.size()<1){
            System.out.println("There are no customers!");
        } else{
            do {
                System.out.println("Which customer ID do you want to delete?");
                int id = input.nextInt();
                try {
                    customers.remove(id);
                    System.out.println("You have deleted customer nr " + id + " from the system!");
                    i = 1;
                } catch (Exception e) {
                    //  Block of code to handle errors
                    System.out.println("There is no customer with id nr " + id + " in the system");
                }
            }while(i != 1);
        }
    }

    public void showAllCustomers(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to read customer information from file? (Y/N)");
        if(input.nextLine().equalsIgnoreCase("Y")) {
            customers = (ArrayList<Customer>) objectIO.ReadObjectFromFile("customerlist.txt");
        }
        //Collections.sort(customers);
        if (customers == null || customers.size() < 1) {
            System.out.println("There are no customers!");
            customers = new ArrayList<>();
        } else {
            Collections.sort(customers);
            for(Customer customer : customers){
                System.out.println(customer);
            }
        }
    }

    public void showCustomer(){
        Scanner input = new Scanner(System.in);
        if(customers.size() < 1){
            System.out.println("There are no customers!");
        } else {
            System.out.println("Which customer do you want to show? (Enter ID)");
            int id = input.nextInt();
            try {
                System.out.println("ID number " + id + ", " + customers.get(id));
            }
            catch(Exception e) {
                //  Block of code to handle errors
                System.out.println("There is no customer with id nr " + id + " in the system");
            }
        }
    }

    public void showAllEmployees() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to read employee information from file? (Y/N)");
        if(input.nextLine().equalsIgnoreCase("Y")) {
            employees = (ArrayList<Employee>) objectIO.ReadObjectFromFile("employeelist.txt");
        }
        if (employees == null || employees.size() < 1) {
            System.out.println("There are no employees!");
            employees = new ArrayList<>();
        } else {
            System.out.println(employees);
        }
    }

    public void addEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter employees name: ");
        String name = input.nextLine();
        System.out.println("Enter employee workarea: ");
        String workArea = input.nextLine();

        Employee employee = new Employee(name, workArea);
        employees.add(employee);
        System.out.println("Do you want to save employee information on file? (Y/N)");
        if(input.nextLine().equalsIgnoreCase("Y")){
            objectIO.WriteObjectToFile("employeelist.txt", employees);
        }
    }

    public void addCar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter brand of  car: ");
        String brand = input.nextLine();
        System.out.println("Enter year of manufacture: ");
        String yearAsString = input.nextLine();
        int year = Integer.parseInt(yearAsString);
        System.out.println("Enter price of car: ");
        String priceAsString = input.nextLine();
        int price = Integer.parseInt(priceAsString);

        Car car = new Car(brand, year, price);
        cars.add(car);
        System.out.println("The car has been entered into the system.");
    }

    public void showAllCars(){
        if(cars.size() < 1){
            System.out.println("There are no cars in the system!");
        } else {
            System.out.println("List of cars in system: ");
            for(Car car : cars){
                System.out.println("Brand: " + car.getBrand() + ", Year: "+ car.getYear() + ", Price: " + car.getPrice());
            }
        }

    }

    public ArrayList<Car> getAllCars(){
        return cars;
    }




    public void info(){
        System.out.println("This is a Taxi Booking Program. Pretty awesome huh?");
    }



}
