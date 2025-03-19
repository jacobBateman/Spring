package org.example;

import java.util.Objects;
import java.util.Random;

abstract public class Vehicle {
    static int globalid  = 0;
    String brand;
    String model;
    int year;
    int price;
    int id = ++globalid;
    String type;

//    public Vehicle(String brand, String model, int year, int price) {
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.price = price;
//
//    }


    public Vehicle(String brand, String model, int year, int price, String type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.type = type;
    }

    public String toCsv() {
        return type + ";" + brand + ";" + model + ";" + year + ";" + price + ";" + id + "\n";
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, id);
    }

}
