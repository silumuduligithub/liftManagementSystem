package com.example.liftManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private int PassengerId;
    private int LiftNo;
    private  int weight;
}
