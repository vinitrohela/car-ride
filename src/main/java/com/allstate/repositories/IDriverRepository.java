package com.allstate.repositories;


import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IDriverRepository extends CrudRepository<Driver,Integer> {
    public Driver findByName(String name);
}
