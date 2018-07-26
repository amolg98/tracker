package me.amolgupta.service;

import me.amolgupta.entity.Vehicle;
import me.amolgupta.exception.BadRequestException;
import me.amolgupta.exception.ResourceNotFoundException;
import me.amolgupta.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amolg on 6/24/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findByVIN(String vin) {
        Vehicle existingVehicle = vehicleRepository.findByVIN(vin);
        if(existingVehicle == null) {
            throw new ResourceNotFoundException("Vehicle with vin "+vin+" doesn't exist!");
        }
        return existingVehicle;
    }

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findByVIN(vehicle.getVin());
        if(existingVehicle != null) {
            throw new BadRequestException("Vehicle with vin "+ vehicle.getVin() +" already exist!");
        }
        return vehicleRepository.create(vehicle);
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicleList) {
        ArrayList<Vehicle> vehList = new ArrayList<Vehicle>();
        for(Vehicle vehicle : vehicleList) {
            vehList.add(update(vehicle));
        }
        return vehList;
    }

    @Transactional
    public Vehicle update(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findByVIN(vehicle.getVin());
        if (existingVehicle == null) {
            return vehicleRepository.create(vehicle);
        }
        return vehicleRepository.update(vehicle);
    }

    @Transactional
    public void delete(String vin) {
        Vehicle vehicleExisting = vehicleRepository.findByVIN(vin);
        if(vehicleExisting == null){
            throw new ResourceNotFoundException("Vehicle with vin "+vin+" doesn't exist!");
        }
        vehicleRepository.delete(vehicleExisting);
    }
}
