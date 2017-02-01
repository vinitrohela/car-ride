package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.enums.CarType;
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
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear(2018);
        car.setCar_type(CarType.LUX);
        Driver driver = this.driverService.findById(1);
        car.setDriver(driver);
        Car newcar = this.carService.create(car);
        assertEquals(3,newcar.getId());
        assertEquals("Honda", newcar.getMake());
        assertEquals("Civic", newcar.getModel());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        Car c1 = this.carService.findById(1);
        assertEquals("hyundai",c1.getMake());
    }

    @Test
    public void shouldFindByName() throws Exception {
        Car c1 = this.carService.findByMake("hyundai");
        assertEquals("i20",c1.getModel());

    }

    @Test
    @Transactional
    public void shouldDeleteById() throws Exception {
        this.carService.deleteById(2);
        Car car = this.carService.findById(2);
        assertNull(car);
    }

    @Test
    @Transactional
    public void shouldDriverForACar() throws Exception {
        Car car = this.carService.findById(1);
        Driver driver = car.getDriver();
        assertEquals("rohit", driver.getName());
    }

    @Test
    @Transactional
    public void shouldFindAllTheTripACarHasBeenOn() throws Exception {
        Car car = this.carService.findById(1);
        List<Trip> trips = car.getTrip();
        assertEquals(1, trips.size());
    }
}