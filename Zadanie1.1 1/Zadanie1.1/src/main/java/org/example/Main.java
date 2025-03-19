package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User me = new User("Jacobsen");
//        me.getVehilces();
//        me.rentVehicle("McLaren","W1");
//        System.out.println("-----------------------");
//        me.getVehilces();
//        me.returnVehicle("McLaren","W1");
//        System.out.println("-----------------------");
//        me.getVehilces();

        System.out.println("1 - sprawdź dostępne pojazdy\n" +
                "2 - wypożycz \n" +
                "3 - zwróć\n" +
                "4 - wyjdź\n");

        while (true){
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equals("1")) {
                me.getVehilces();
            }
            else if (option.equals("2")){
                System.out.println("Podaj markę i model: ");
                String brand = sc.nextLine();
                String model = sc.nextLine();
                me.rentVehicle(brand, model);
            }
            else if (option.equals("3")) {
                System.out.println("Podaj markę i model: ");
                String brand = sc.nextLine();
                String model = sc.nextLine();
                me.returnVehicle(brand, model);
            }
            else if (option.equals("4")){
                break;
            }
            System.out.println("Wybierz następną opcję: ");
        }

        System.out.println("---------------------------");

        Car car = new Car("Toyoya", "CHR", 2022, 150000, "car");
        Car otherCar = car;
        if (car.equals(otherCar)) {
            System.out.println("Tak");
        }
        if (car.hashCode() == otherCar.hashCode()) {
            System.out.println("Tak");
        }
    }
}