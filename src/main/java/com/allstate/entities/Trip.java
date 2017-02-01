package com.allstate.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip {
    private int id;
    private int version;
    private Date start_time;
    private Date end_time;
    private int cost;
    private int tip;
    private int total_cost;
    private Car car;
    private int kms_driven;
    private City city;
    private Passenger passenger;
    private Driver driver;
    private Date created;
    private Date modified;

    public Trip() {
    }

    public Trip(Car car, City city, Passenger passenger, Driver driver) {
        this.car = car;
        this.city = city;
        this.passenger = passenger;
        this.driver = driver;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    @NotNull
    public int getTip() {
        return tip;
    }
    public void setTip(int tip) {
        this.tip = tip;
    }

    @NotNull
    public int getTotal_cost() {
        return total_cost;
    }
    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    @ManyToOne
    @JoinColumn(name="car_id")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @NotNull
    public int getKms_driven() {
        return kms_driven;
    }
    public void setKms_driven(int kms_driven) {
        this.kms_driven = kms_driven;
    }

    @CreationTimestamp
    public Date getStart_time() {
        return start_time;
    }
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    @UpdateTimestamp
    public Date getEnd_time() {
        return end_time;
    }
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}