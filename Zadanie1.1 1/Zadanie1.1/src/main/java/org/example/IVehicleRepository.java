package org.example;

import java.io.IOException;

public interface IVehicleRepository {
    void rentVehicle(String brand, String model);
    void returnVehicle(String brand, String model);
    void getVehilces();
    void save(String path) throws IOException;

}
