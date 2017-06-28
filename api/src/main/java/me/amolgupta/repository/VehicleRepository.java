package me.amolgupta.repository;


import me.amolgupta.entity.Vehicle;

import java.util.List;

/**
 * Created by amolg on 6/23/2017.
 */
public interface VehicleRepository {

    List<Vehicle> findAll();
    Vehicle findByVIN(String vin);
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Vehicle vehicle);
}
