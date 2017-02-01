package com.allstate.repositories;

import com.allstate.entities.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ITripRepository extends CrudRepository<Trip,Integer>{

    String sql1 = "select min(kms_driven) from trips where id = :id";
    @Query(value = sql1, nativeQuery = true)
    public int findShortestTrip(@Param("id") int id);
}
