package me.amolgupta.service;

import me.amolgupta.entity.Alerts;
import me.amolgupta.entity.Reading;
import me.amolgupta.entity.Vehicle;
import me.amolgupta.exception.BadRequestException;
import me.amolgupta.exception.ResourceNotFoundException;
import me.amolgupta.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amolg on 6/24/2017.
 */

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AlertsService alertsService;

    @Autowired
    private EmailServiceImpl emailService;

    public List<Reading> findAll() {
        return readingRepository.findAll();
    }

    public Reading findById(String id) {
        Reading existingReading = readingRepository.findById(id);
        if(existingReading == null) {
            throw new ResourceNotFoundException("Reading with id "+ id +" doesn't exist!");
        }
        return existingReading;
    }

    public List<Reading> findByVIN(String vin) {
        List<Reading> readingsList = readingRepository.findByVIN(vin);
        if(readingsList.isEmpty()){
            throw new ResourceNotFoundException("No readings for Vehicle with VIN "+ vin + "exists!");
        }
        return readingsList;
    }

    @Transactional
    public Reading create(Reading reading) {

        Reading existingReading = readingRepository.findById(reading.getId());
        if(existingReading != null) {
            throw new BadRequestException("Reading with id "+ reading.getId() +" already exist!");
        }
        Reading currReading = readingRepository.create(reading);
        Vehicle vehicle = vehicleService.findByVIN(currReading.getVin());


        /**
         * Checking and adding all the alerts based on recently added reading
         * and sending email in case any high alert is encountered
         * */

        if(currReading.getEngineRpm() > vehicle.getRedLineRpm()){
            createAlert("HIGH", currReading);
            emailService.sendSimpleMessage("testemailspring9@gmail.com","High Alert!!","Alert!! Current engine rpm"+ currReading.getEngineRpm()
                    + " is more than prescribed limit "+ vehicle.getRedLineRpm());
        }

        if(currReading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())){
            createAlert("MEDIUM", currReading);
        }

        if(currReading.isEngineCoolantLow() == true || currReading.isCheckEngineLightOn() == true){
            createAlert("LOW", currReading);
        }

        if(currReading.getTires().getFrontLeft() < 32 || currReading.getTires().getFrontLeft() > 36
                || currReading.getTires().getFrontRight() < 32 || currReading.getTires().getFrontRight() > 36
                || currReading.getTires().getRearLeft() < 32 || currReading.getTires().getRearLeft() > 36
                || currReading.getTires().getRearRight() < 32 || currReading.getTires().getRearRight() > 36
                ){
            createAlert("LOW", currReading);
        }

        return currReading;
    }

    @Transactional
    public void createAlert(String priority, Reading currReading){
        Alerts alerts = new Alerts();
        alerts.setReadingId(currReading.getId());
        alerts.setVin(currReading.getVin());
        alerts.setPriority(priority);
        alertsService.create(alerts);
    }


    @Transactional
    public Reading update(Reading reading) {
        Reading existingReading = readingRepository.findById(reading.getId());
        if (existingReading == null) {
            return readingRepository.create(reading);
        }
        return readingRepository.update(reading);
    }

    @Transactional
    public void delete(String id) {
        Reading existingReading = readingRepository.findById(id);
        if(existingReading == null) {
            throw new ResourceNotFoundException("Reading with id "+ id +" doesn't exist!");
        }
        readingRepository.delete(existingReading);
    }

}
