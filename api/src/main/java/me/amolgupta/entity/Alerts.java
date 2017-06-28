package me.amolgupta.entity;


import javax.persistence.*;
import java.util.UUID;

/**
 * Created by amolg on 6/26/2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll", query = "SELECT alerts FROM Alerts alerts"),
        @NamedQuery(name = "Alerts.findByVIN", query = "SELECT alerts FROM Alerts alerts WHERE alerts.vin=:paramVIN")
})
public class Alerts {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String priority;
    private String message;
    private String readingId;
    private String vin;

    public Alerts() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReadingId() {
        return readingId;
    }

    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "id='" + id + '\'' +
                ", priority='" + priority + '\'' +
                ", message='" + message + '\'' +
                ", readingId='" + readingId + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
