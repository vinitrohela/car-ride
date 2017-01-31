package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.enums.CarType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

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
        car.setMake("Nissan");
        car.setModel("NM234");
        car.setYear(2018);
        Driver driver = this.driverService.findById(1);
        car.setDriver(driver);
        car.setCar_type(CarType.BASIC);
        Car newcar = this.carService.create(car);
        assertEquals(2,newcar.getId());
        assertEquals("Nissan", newcar.getMake());
        assertEquals("NM234", newcar.getModel());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        Car c1 = this.carService.findById(1);
        assertEquals("BMW",c1.getMake());
    }

    @Test
    public void shouldFindByName() throws Exception {
        Car c1 = this.carService.findByMake("BMW");
        assertEquals("DSFG343",c1.getModel());

    }
}