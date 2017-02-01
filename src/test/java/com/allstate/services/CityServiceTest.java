package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception {
        City city = new City();
        city.setName("davangere");
        city.setState("ktk");
        city.setDay_rate(56);
        city.setNight_rate(100);
        City after = this.cityService.create(city);
        assertEquals(3, after.getId());
        assertEquals("davangere", after.getName());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        City c1 = this.cityService.findById(1);
        assertEquals("bangalore",c1.getName());
    }

    @Test
    public void shouldFindByName() throws Exception {
        City c1 = this.cityService.findByName("bangalore");
        assertEquals("karnataka",c1.getState());

    }

    @Test
    @Transactional
    public void shouldDeleteById() throws Exception {
        this.cityService.deleteById(2);
        City city = this.cityService.findById(2);
        assertNull(city);
    }

    @Test
    @Transactional
    public void shouldFindAllDriverInACity() throws Exception {
        City city = this.cityService.findById(1);
        List<Driver> driver = city.getDrivers();
        assertEquals(4, driver.size());
    }

    @Test
    @Transactional
    public void shouldFindAllPassengerForACity() throws Exception {
        City city = this.cityService.findById(1);
        List<Passenger> passengers = city.getPassengers();
        assertEquals(4, passengers.size());
    }
}