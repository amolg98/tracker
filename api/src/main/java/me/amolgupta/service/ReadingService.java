package me.amolgupta.service;

import me.amolgupta.entity.Reading;

import java.util.List;

/**
 * Created by amolg on 6/24/2017.
 */
public interface ReadingService {

    List<Reading> findAll();
    Reading findById(String id);
    List<Reading> findByVIN(String vin);
    Reading create(Reading reading);
    //List<Reading> update(List<Reading> reading);
    Reading update(Reading reading);
    void delete(String id);

}
