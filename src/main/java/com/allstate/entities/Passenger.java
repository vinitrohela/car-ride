package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "passengers")
public class Passenger {
    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private int credit_balance;
    private Date created;
    private Date modified;
    private List<Trip> trip;
    private City city;
    private List<Driver> drivers;

    public Passenger() {
    }

    public Passenger(String name, int age, Gender gender, int credit_balance) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.credit_balance = credit_balance;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE','FEMALE')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @NotNull
    public int getCredit_balance() {
        return credit_balance;
    }
    public void setCredit_balance(int credit_balance) {
        this.credit_balance = credit_balance;
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

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    public List<Trip> getTrip() {
        return trip;
    }
    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }

    @ManyToOne
    @JoinTable(name = "trips",
            joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id", referencedColumnName = "id"))
    @JsonIgnore
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "passenger")
    @JsonIgnore
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}