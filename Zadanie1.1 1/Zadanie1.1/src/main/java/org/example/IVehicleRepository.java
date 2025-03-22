package org.example;

import java.io.IOException;
import java.util.Optional;

public interface IVehicleRepository {
    void rentVehicle(String brand, String model);
    void returnVehicle(String brand, String model);
    void getVehilces();
    void save(String path) throws IOException;
    void addVehicle(String type, String brand, String model, int year, int price, Optional<String> kategoria);
    void removeVehicle(String brand, String model);

}
