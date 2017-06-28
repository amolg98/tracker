package me.amolgupta.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;

/**
 * Created by amolg on 6/23/2017.
 * Vehicle Entity with all the parameters required
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "SELECT vehicle FROM Vehicle vehicle"),
        @NamedQuery(name = "Vehicle.findByVIN", query = "SELECT vehicle FROM Vehicle vehicle WHERE vehicle.vin=:paramVIN")
})
public class Vehicle {

    @JsonProperty("vin")
    @Id
    private String vin;

    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("year")
    private int year;
    @JsonProperty("redlineRpm")
    private int redLineRpm;
    @JsonProperty("maxFuelVolume")
    private int maxFuelVolume;
    @JsonProperty("lastServiceDate")
    private Timestamp lastServiceDate;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedLineRpm() {
        return redLineRpm;
    }

    public void setRedLineRpm(int redLineRpm) {
        this.redLineRpm = redLineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redLineRpm=" + redLineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
