package me.amolgupta.repository;

import me.amolgupta.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by amolg on 6/23/2017.
 */
@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager readingEntityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = readingEntityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public Reading findById(String id) {
        return readingEntityManager.find(Reading.class, id);
    }

    public List<Reading> findByVIN(String vin) {
        TypedQuery<Reading> query = readingEntityManager.createNamedQuery("Reading.findByVIN", Reading.class);
        query.setParameter("paramVIN", vin);

        List<Reading> resultList = query.getResultList();
        return resultList;
    }

    public Reading create(Reading reading) {
        readingEntityManager.persist(reading);
        return reading;
    }

    public Reading update(Reading reading) {
        readingEntityManager.merge(reading);
        return reading;
    }

    public void delete(Reading reading) {
        readingEntityManager.remove(reading);
    }
}
