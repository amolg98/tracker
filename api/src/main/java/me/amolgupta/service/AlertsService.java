package me.amolgupta.service;

import me.amolgupta.entity.Alerts;

import java.util.List;

/**
 * Created by amolg on 6/26/2017.
 */


public interface AlertsService {
    List<Alerts> findAll();
    Alerts findById(String id);
    List<Alerts> findByVIN(String vin);
    Alerts create(Alerts alerts);
    List<Alerts> findByHighAlerts();
    Alerts update(Alerts alerts);
    void delete(String id);
}
