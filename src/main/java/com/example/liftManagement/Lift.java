package com.example.liftManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lift extends Passenger{
    private int LiftNo;
    private int  CapacityInWeight;
    private int  capacityInPerson;
    private List<Passenger> passengers = new ArrayList<>();
}
