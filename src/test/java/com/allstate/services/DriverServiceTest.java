package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
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
public class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateDriver() throws Exception {
        Driver driver = new Driver();
        driver.setName("sameer");
        driver.setAge(24);
        driver.setGender(Gender.MALE);
        Driver after = this.driverService.create(driver);
        assertEquals(2, after.getId());
        assertEquals("sameer", after.getName());
    }

    @Test
    public void shouldFIndById() throws Exception {
        Driver drive = this.driverService.findById(1);
        assertEquals("rohit", drive.getName());
    }

    @Test
    public void shouldNotFIndById() throws Exception {
        Driver driver = this.driverService.findById(3);
        assertNull(driver);
    }

    @Test
    public void shouldFindByName() throws Exception {
        Driver driver = this.driverService.findByName("rohit");
        assertEquals(1, driver.getId());
    }

    @Test
    public void shouldNotFindByName() throws Exception {
        Driver driver = this.driverService.findByName("sameer");
        assertNull(driver);
    }

    @Test
    @Transactional
    public void shouldFindAllCarsDrivenByDriver() throws Exception {
        Driver driver = this.driverService.findById(1);
        List<Car> cars = driver.getCars();
        assertEquals(1, cars.size());
    }

}