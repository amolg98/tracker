package me.amolgupta.repository;

import me.amolgupta.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by amolg on 6/23/2017.
 */

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager vehicleEntityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = vehicleEntityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findByVIN(String vin) {
        return vehicleEntityManager.find(Vehicle.class, vin);
    }

    public Vehicle create(Vehicle vehicle) {
        vehicleEntityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        vehicleEntityManager.merge(vehicle);
        return vehicle;
    }

    public void delete(Vehicle vehicle) {
        vehicleEntityManager.remove(vehicle);
    }
}
