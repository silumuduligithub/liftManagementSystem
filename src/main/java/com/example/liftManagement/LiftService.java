package com.example.liftManagement;

import jdk.jfr.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiftService {
    @Autowired
    LiftRepository liftRepository = new LiftRepository();
    public void addLift(Lift lift) {
        liftRepository.addLift(lift);
    }

    public void addPassenger(Passenger passenger) {
        liftRepository.addPassenger(passenger);
    }

    public void deletePassenger() {
        List<Passenger> passengerList = liftRepository.getPassengers();
        for(Passenger passenger : passengerList){
            if(passenger.getPassengerId() < 5){
                liftRepository.deletePassenger(passenger.getPassengerId());
                liftRepository.deletePassengerFromLift(passenger.getLiftNo(), passenger.getPassengerId());
            }
        }
    }

    public int getPeople(int wt, Lift lift) {
        return liftRepository.getPeople(wt, lift);
    }

    public int getPeoplegeterFifty(Lift lift) {
        return liftRepository.getPeopleGreaterFift(lift);
    }
}
