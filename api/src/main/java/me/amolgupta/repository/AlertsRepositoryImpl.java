package me.amolgupta.repository;

import me.amolgupta.entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by amolg on 6/26/2017.
 */

@Repository
public class AlertsRepositoryImpl implements AlertsRepository {

    @PersistenceContext
    private EntityManager alertsEntityManager;

    public List<Alerts> findAll() {
        TypedQuery<Alerts> query = alertsEntityManager.createNamedQuery("Alerts.findAll", Alerts.class);
        return query.getResultList();
    }

    public Alerts findById(String id) {
        return alertsEntityManager.find(Alerts.class, id);
    }

    public List<Alerts> findByVIN(String vin) {
        TypedQuery<Alerts> query = alertsEntityManager.createNamedQuery("Alerts.findByVIN", Alerts.class);
        query.setParameter("paramVIN", vin);

        List<Alerts> resultList = query.getResultList();
        return resultList;
    }

    public Alerts create(Alerts alerts) {
        alertsEntityManager.persist(alerts);
        return alerts;
    }

    public Alerts update(Alerts alerts) {
        alertsEntityManager.merge(alerts);
        return alerts;
    }

    public void delete(Alerts alerts) {
        alertsEntityManager.remove(alerts);
    }

}
