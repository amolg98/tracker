package me.amolgupta.repository;

import me.amolgupta.entity.Alerts;

import java.util.List;

/**
 * Created by amolg on 6/26/2017.
 */


public interface AlertsRepository {

    List<Alerts> findAll();
    Alerts findById(String id);
    List<Alerts> findByVIN(String vin);
    Alerts create(Alerts alerts);
    Alerts update(Alerts alerts);
    void delete(Alerts alerts);

}
