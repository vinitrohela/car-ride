package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private ITripRepository tripRepository;
    private DriverService driverService;
    private PassengerService passengerService;

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public Trip create(Trip trip) {
        Driver driver = this.driverService.findById(trip.getDriver().getId());
        Passenger passenger=this.passengerService.findById(trip.getPassenger().getId());
        if (driver.getViolations() < 3 && passenger.getCredit_balance() > trip.getTotal_cost()) {
            passenger.setCredit_balance(passenger.getCredit_balance() - trip.getTotal_cost());
            return this.tripRepository.save(trip);
        }
        else
            return null;
    }

    public Trip findById(int id) {
        return this.tripRepository.findOne(id);
    }

    public int findShortestTrip(int passenger_id){
        return this.tripRepository.findShortestTrip(passenger_id);
    }

    public int findLongestTrip(int passenger_id){
        return this.tripRepository.findLongestTrip(passenger_id);
    }
}
