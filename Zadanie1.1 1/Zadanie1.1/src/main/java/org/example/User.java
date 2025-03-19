package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements IVehicleRepository{
    private String username;
    String password;
    String role;
    Vehicle vehicle;
    String path = "vehicles.txt";
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Vehicle> rented = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User(String username) {
        this.username = username;
        try {
            readFromFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void readFromFile(String path) throws IOException {
        String read;
        //File file = new File(path);
        FileReader file = new FileReader(path);
        BufferedReader bf = new BufferedReader(file);

        while((read = bf.readLine()) != null){
            String[] info = read.split(";");
            if (info[0].equals("motorcycle")){
                Motorcycle motorcycle = new Motorcycle(info[1], info[2], Integer.valueOf(info[3]), Integer.valueOf(info[4]), info[0],info[6]);
                vehicles.add(motorcycle);
            } else {
                Car car = new Car(info[1], info[2], Integer.valueOf(info[3]), Integer.valueOf(info[4]), info[0]);
                vehicles.add(car);
            }
        }
    }


    @Override
    public void rentVehicle(String brand, String model) {
        Iterator<Vehicle> iter = vehicles.iterator();
        while (iter.hasNext()) {
            Vehicle v = iter.next();
            if (v.brand.equals(brand) && v.model.equals(model)) {
                rented.add(v);
                iter.remove();
                break;
            }
        }

        try {
            save(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void returnVehicle(String brand, String model) {
        Iterator<Vehicle> iter = rented.listIterator();
//        for (Vehicle v : rented){
//            if (v.brand.equals(brand) && v.model.equals(model)){
//                vehicles.add(v);
//                //rented.remove(v);
//
//            }
//        }
        while(iter.hasNext()){
            Vehicle v = iter.next();
            if (v.brand.equals(brand) && v.model.equals(model)){
                    vehicles.add(v);
//                //rented.remove(v);

                iter.remove();
            }
        }
        try {
            save(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getVehilces() {
        for (Vehicle v : vehicles){
            if (v instanceof Motorcycle){
                Motorcycle m = (Motorcycle) v;

                System.out.println(m);
                //System.out.println("Category: " + m.category);
            } else {
                System.out.println(v.toString());
            }
        }
    }

    @Override
    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path, false);
        for (Vehicle v : vehicles) {
            writer.write(v.toCsv());
        }
        writer.close();
    }

}
