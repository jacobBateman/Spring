package org.example;

public class Motorcycle extends Vehicle{
    String category;

//    public Motorcycle(String brand, String model, int year, int price, String category) {
//        super(brand, model, year, price);
//        this.category = category;
//    }


    public Motorcycle(String brand, String model, int year, int price, String type, String category) {
        super(brand, model, year, price, type);
        this.category = category;
    }

    @Override
    public String toCsv() {
        return type + ";" + brand + ";" + model + ";" + year + ";" + price + ";" + id + ";" + category + "\n";
    }


    @Override
    public String toString() {
        return "Motorcycle{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
