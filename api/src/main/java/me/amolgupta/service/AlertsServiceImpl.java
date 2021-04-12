package me.amolgupta.service;

import me.amolgupta.entity.Alerts;
import me.amolgupta.exception.BadRequestException;
import me.amolgupta.exception.ResourceNotFoundException;
import me.amolgupta.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by amolg on 6/26/2017.
 */

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    private AlertsRepository alertsRepository;

    public List<Alerts> findAll() {
        return alertsRepository.findAll();
    }

    public Alerts findById(String id) {
        Alerts existingAlerts = alertsRepository.findById(id);
        if(existingAlerts == null) {
            throw new ResourceNotFoundException("Alerts with id "+ id +" doesn't exist!");
        }
        return existingAlerts;
    }

    public List<Alerts> findByVIN(String vin) {
        List<Alerts> alertsList = alertsRepository.findByVIN(vin);
        if(alertsList.isEmpty()){
            throw new ResourceNotFoundException("No alerts for Vehicle with VIN "+ vin + "exists!");
        }
        return alertsList;
    }


    public List<Alerts> findByHighAlerts() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis() - 7200000);
        String priority = "HIGH";
        return alertsRepository.findByHighAlerts(priority, currentTimestamp);
    }

    public Alerts create(Alerts alerts) {
        Alerts existingAlerts = alertsRepository.findById(alerts.getId());
        if(existingAlerts != null) {
            throw new BadRequestException("Alerts with id "+ alerts.getId() +" already exist!");
        }
        Alerts currAlerts = alertsRepository.create(alerts);
        return currAlerts;
    }

    public Alerts update(Alerts alerts) {
        Alerts existingAlerts = alertsRepository.findById(alerts.getId());
        if (existingAlerts == null) {
            return alertsRepository.create(alerts);
        }
        return alertsRepository.update(alerts);
    }

    public void delete(String id) {
        Alerts existingAlerts = alertsRepository.findById(id);
        if(existingAlerts == null) {
            throw new ResourceNotFoundException("Alerts with id "+ id +" doesn't exist!");
        }
        alertsRepository.delete(existingAlerts);
    }
}
