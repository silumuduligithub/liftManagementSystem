package com.example.liftManagement;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class LiftRepository {
    private HashMap<Integer, Lift> liftData = new HashMap<>();
    private HashMap<Integer, Passenger>passengerData = new HashMap<>();
    public void addLift(Lift lift) {
        liftData.put(lift.getLiftNo(), lift);
    }

    public void addPassenger(Passenger passenger) {
        int liftNo = passenger.getLiftNo();
        Lift lift = liftData.get(liftNo);
        List<Passenger> passengerList = lift.getPassengers();
        passengerList.add(passenger);
        passengerData.put(passenger.getPassengerId(), passenger);
    }

    public void deletePassenger(int id) {
        passengerData.remove(id);
    }
    public void deletePassengerFromLift(int liftNo, int requiredPassengerId){
        Lift lift = liftData.get(liftNo);
        List<Passenger> passengers = lift.getPassengers();
        for(Passenger passenger : passengers){
            if(passenger.getPassengerId() == requiredPassengerId)passengers.remove(passenger);
        }
    }

    public List<Passenger> getPassengers() {
        List<Passenger> passengers = new ArrayList<>(passengerData.values());
        return passengers;
    }
    public int getPeople(int wt, Lift lift) {
        int liftWt = lift.getWeight();
        return liftWt % wt;
    }

    public int getPeopleGreaterFift(Lift lift) {
        List<Passenger> passengers= lift.getPassengers();
        int count = 0;
        for(Passenger passenger : passengers){
            if(passenger.getWeight() > 50){
                count++;
            }
        }
        return count;
    }
}
