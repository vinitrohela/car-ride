package com.allstate.repositories;

import com.allstate.entities.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface IPassengerRepository extends CrudRepository<Passenger,Integer>{
    public Passenger findByName(String name);
}

