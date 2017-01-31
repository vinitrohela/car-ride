package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cities")

public class City {
    private int id;
    private int version;
    private String name;
    private String state;
    private int day_rate;
    private int night_rate;
    private Date created;
    private Date modified;
    private Trip trip;

    public City() {
    }

    public City(String name, String state, int day_rate, int night_rate) {
        this.name = name;
        this.state = state;
        this.day_rate = day_rate;
        this.night_rate = night_rate;
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

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }


    public int getDay_rate() {
        return day_rate;
    }
    public void setDay_rate(int day_rate) {
        this.day_rate = day_rate;
    }


    public int getNight_rate() {
        return night_rate;
    }
    public void setNight_rate(int night_rate) {
        this.night_rate = night_rate;
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

    @OneToMany
    @JoinColumn(name = "city_id")
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}