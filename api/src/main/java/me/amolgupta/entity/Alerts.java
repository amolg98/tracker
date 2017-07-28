package me.amolgupta.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by amolg on 6/26/2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll", query = "SELECT alerts FROM Alerts alerts"),
        @NamedQuery(name = "Alerts.findByHighAlerts", query = "SELECT new me.amolgupta.entity.Alerts(a.vin, COUNT(a.priority)) FROM Alerts a WHERE a.priority=:paramPriority and a.timestamp >= :paramCurrentTimestamp group by a.vin order by count(a.priority) desc"),
        @NamedQuery(name = "Alerts.findByVIN", query = "SELECT alerts FROM Alerts alerts WHERE alerts.vin=:paramVIN")
})
public class Alerts {


    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("message")
    private String message;

    @JsonProperty("readingId")
    private String readingId;

    @JsonProperty("vin")
    private String vin;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp timestamp;


    @JsonProperty("count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private long count;

    public Alerts() {
        this.id = UUID.randomUUID().toString();
    }

    public Alerts(String newVin, long count){
        this.vin = newVin;
        this.count = count;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "id='" + id + '\'' +
                ", priority='" + priority + '\'' +
                ", message='" + message + '\'' +
                ", readingId='" + readingId + '\'' +
                ", vin='" + vin + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
