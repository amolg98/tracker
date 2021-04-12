package me.amolgupta.repository;

import me.amolgupta.entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
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

        /*if(resultList.size()!=0) {
            System.out.println("Not empty list ");

            for (Alerts alert : resultList) {
                System.out.println(alert.getPriority() + " " + alert.getId() + " " + alert.getVin());
            }
        }*/

        return resultList;
    }

    public List<Alerts> findByHighAlerts(String priority, Timestamp currentTimestamp){
        System.out.println("In repo start ");

        TypedQuery<Alerts> query = alertsEntityManager.createNamedQuery("Alerts.findByHighAlerts", Alerts.class);
        query.setParameter("paramPriority", priority);
        query.setParameter("paramCurrentTimestamp", currentTimestamp);
        System.out.println("In repository");
        List<Alerts> list = query.getResultList();
        System.out.println("In repository  after");
        System.out.println(list.get(0));

        return list;
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
