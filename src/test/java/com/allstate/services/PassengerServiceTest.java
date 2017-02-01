package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
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
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreatePassenger() throws Exception {
        Passenger passenger = new Passenger();
        passenger.setName("vinit");
        passenger.setAge(23);
        passenger.setGender(Gender.MALE);
        passenger.setCredit_balance(500);
        Passenger after = this.passengerService.create(passenger);
        assertEquals(3, after.getId());
        assertEquals("vinit", after.getName());
    }

    @Test
    public void shouldFindById() throws Exception {
        Passenger p1 = this.passengerService.findById(1);
        assertEquals("vinit",p1.getName());
    }

    @Test
    public void shouldFindByName() throws Exception {
        Passenger p1 = this.passengerService.findByName("vinit");
        assertEquals(1, p1.getId());
    }

    @Test
    @Transactional
    public void shouldDeleteById() throws Exception {
        this.passengerService.deleteById(1);
        Passenger passenger = this.passengerService.findById(1);
        assertNull(passenger);
    }

    @Test
    @Transactional
    public void shouldGivenAPassengerToFindAllDriver() throws Exception {
        Passenger passenger = this.passengerService.findById(1);
        List<Driver> drivers = passenger.getDrivers();
        assertEquals(4, drivers.size());
    }
}