package com.allstate.entities;

import com.allstate.enums.CarType;
import com.sun.istack.internal.Nullable;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")

public class Car {
    private int id;
    private int version;
    private String make;
    private String model;
    private int year;
    private CarType car_type;
    private Date created;
    private Date modified;
    private Driver driver;
    private Trip trip;

    public Car() {
    }

    public Car(String make, String model, int year, CarType car_type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.car_type = car_type;
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
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @NotNull
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @NotNull
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('BASIC','LUX')")
    public CarType getCar_type() {
        return car_type;
    }
    public void setCar_type(CarType car_type) {
        this.car_type = car_type;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getmodified() {
        return modified;
    }
    public void setmodified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToOne
    @JoinColumn(name = "car_id")
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}