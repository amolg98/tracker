package me.amolgupta.service;


import me.amolgupta.entity.Vehicle;

import java.util.List;

/**
 * Created by amolg on 6/24/2017.
 */
public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle findByVIN(String vin);
    Vehicle create(Vehicle vehicle);
    List<Vehicle> update(List<Vehicle> vehicleList);
    Vehicle update(Vehicle vehicle);
    void delete(String vin);

}
