package com.allstate.services;

import com.allstate.entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {

    @Autowired
    private TripService tripService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;

    private Trip trip;

    @Before
    public void setUp() throws Exception {
        City city = this.cityService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        Car car =this.carService.findById(1);
        Driver driver =this.driverService.findById(1);
        trip = new Trip(car,city,passenger,driver);
        trip.setKms_driven(10);
        trip.setTip(10);
        trip.setCost(200);
        trip.setTotal_cost(220);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTrip() throws Exception {
        Trip result = this.tripService.create(trip);
        assertEquals(3, result.getId());
        assertEquals(220, result.getTotal_cost());
    }

    @Test
    public void shouldFindById() throws Exception {
        Trip t1 = this.tripService.findById(1);
        assertEquals(100,t1.getCost());
    }

    @Test
    @Transactional
    public void shouldGivenATripFindTheCar() throws Exception {
        Trip trip1 = this.tripService.findById(1);
        Car car = trip1.getCar();
        assertEquals(1, car.getId());
        assertEquals("hyundai", car.getMake());
    }

    @Test
    @Transactional
    public void shouldGivenATripFindTheDriver() throws Exception {
        Trip trip = this.tripService.findById(1);
        Driver driver = trip.getDriver();
        assertEquals(1, driver.getId());
        assertEquals("rohit", driver.getName());
    }

    @Test
    @Transactional
    public void shouldGivenATripFindThePassenger() throws Exception {
        Trip trip = this.tripService.findById(1);
        Passenger passenger = trip.getPassenger();
        assertEquals(1, passenger.getId());
        assertEquals("vinit", passenger.getName());
    }

    @Test
    public void shouldFindShortestTrip() throws Exception {
        Trip trip = this.tripService.findById(1);
        Passenger passenger =trip.getPassenger();
        int shortTrip = this.tripService.findShortestTrip(passenger.getId());
        assertEquals(10, shortTrip);
    }

    @Test
    public void shouldLongestTrip() throws Exception {
        Trip trip = this.tripService.findById(1);
        Passenger passenger =trip.getPassenger();
        int LongTrip = this.tripService.findLongestTrip(passenger.getId());
        assertEquals(20, LongTrip);
    }
}