package com.allstate.entities;

import com.allstate.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Trip trip;

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

    @OneToOne
    @JoinColumn(name = "passenger_id")
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}