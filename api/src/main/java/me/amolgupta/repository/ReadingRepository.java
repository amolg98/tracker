package me.amolgupta.repository;

import me.amolgupta.entity.Reading;

import java.util.List;

/**
 * Created by amolg on 6/23/2017.
 */
public interface ReadingRepository {

    List<Reading> findAll();
    Reading findById(String id);
    List<Reading> findByVIN(String vin);
    Reading create(Reading reading);
    Reading update(Reading reading);
    void delete(Reading reading);

}
