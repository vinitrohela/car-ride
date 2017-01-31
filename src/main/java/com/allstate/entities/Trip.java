package com.allstate.entities;

import com.allstate.enums.DayTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trip")
public class Trip {
    private int id;
    private int version;
    private DayTime time;
    private Double distance;
    private Double cost;
    private int tip;
    private Double total_cost;
    private Car car;
    private City city;
    private Passenger passenger;
    private Date created;
    private Date modified;

    public Trip() {
    }

    public Trip(DayTime time, Double distance, Double cost, int tip, Double total_cost, Car car, City city, Passenger passenger) {
        this.time = time;
        this.distance = distance;
        this.cost = cost;
        this.tip = tip;
        this.total_cost = total_cost;
        this.car = car;
        this.city = city;
        this.passenger = passenger;
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
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DAY','NIGHT')")
    public DayTime getTime() {
        return time;
    }
    public void setTime(DayTime time) {
        this.time = time;
    }

    @NotNull
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @NotNull
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
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
    public Double getTotal_cost() {
        return total_cost;
    }
    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trip")
    @JsonIgnore
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    @JsonIgnore
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trip")
    @JsonIgnore
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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
}