package org.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        UserRepository userRepository = new UserRepository();
        Authntication authntication = new Authntication(userRepository);
        User me = new User("Jacobsen");
        me.password = DigestUtils.sha256Hex("test");
        me.setRole("admin");


        boolean isLoggedIn = false;
        User roger = null;
        while(!isLoggedIn) {
            System.out.println("Podaj login i hasło: ");
            Scanner scanner = new Scanner(System.in);
            String login = scanner.nextLine();
            String password = scanner.nextLine();
            try {
                roger = authntication.authenticate(login, password);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (roger != null) {
                isLoggedIn = true;
                System.out.println("Udało się zalogować!");
            } else {
                System.out.println("Błędny login lub hasło");
            }
        }



        if (roger.getRole().equals("admin")) {
            System.out.println("1 - sprawdź dostępne pojazdy\n" +
                    "2 - wypożycz \n" +
                    "3 - zwróć\n" +
                    "4 - wyjdź\n" +
                    "5 - wyświetl użytkowników\n" +
                    "6 - dodaj pojazd\n" +
                    "7 - usuń pojazd\n" +
                    "8 - dodaj użytkownika");
        } else {
            System.out.println("1 - sprawdź dostępne pojazdy\n" +
                    "2 - wypożycz \n" +
                    "3 - zwróć\n" +
                    "4 - wyjdź\n");
        }

        while (true){
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equals("1")) {
                roger.getVehilces();
            }
            else if (option.equals("2")){
                System.out.println("Podaj markę i model: ");
                String brand = sc.nextLine();
                String model = sc.nextLine();
                roger.rentVehicle(brand, model);
            }
            else if (option.equals("3")) {
                System.out.println("Podaj markę i model: ");
                String brand = sc.nextLine();
                String model = sc.nextLine();
                roger.returnVehicle(brand, model);
            }
            else if (option.equals("4")){
                break;
            } else if(me.role.equals("admin") && option.equals("5")){
                //roger.listUsers();
                try {
                    userRepository.getUsers();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (option.equals("6") && me.role.equals("admin")) {
                System.out.println("Podaj typ, markę, model, rok i cenę: ");
                String type = sc.nextLine();
                String marka = sc.nextLine();
                String model = sc.nextLine();
                String rok = sc.nextLine();
                String cena = sc.nextLine();
                if (type.equals("motorcycle")) {
                    String kategorie = sc.nextLine();
                    roger.addVehicle(type, marka, model, Integer.valueOf(rok),Integer.valueOf(cena), Optional.ofNullable(kategorie));
                } else {
                    roger.addVehicle(type,marka, model, Integer.valueOf(rok),Integer.valueOf(cena), Optional.empty());
                }

            } else if (option.equals("7") && me.role.equals("admin")) {
                System.out.println("Podaj markę i model: ");
                String marka = sc.nextLine();
                String model = sc.nextLine();
                roger.removeVehicle(marka, model);
            } else if(me.role.equals("admin") && option.equals("8")){
                Scanner dane = new Scanner(System.in);
                System.out.println("Podaj nowy login nowego usera: ");
                String username = dane.nextLine();
                System.out.println("Podaj jego rolę: ");
                String userRole = dane.nextLine();
                System.out.println("Podaj jego hasło: ");
                String password = dane.nextLine();
                User user = new User(username);
                user.password = DigestUtils.sha256Hex(password);
                user.setRole(userRole);
                UserRepository.addUser(user);
                userRepository.save(user);
            }
            System.out.println("Wybierz następną opcję: ");
        }

        System.out.println("---------------------------");

//        Car car = new Car("Toyoya", "CHR", 2022, 150000, "car");
//        Car otherCar = car;
//        if (car.equals(otherCar)) {
//            System.out.println("Tak");
//        }
//        if (car.hashCode() == otherCar.hashCode()) {
//            System.out.println("Tak");
//        }
    }
}