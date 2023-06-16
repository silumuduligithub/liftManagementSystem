package com.example.liftManagement;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LiftController {
    @Autowired
    LiftService liftService = new LiftService();
    @PostMapping("/addLift")
    public ResponseEntity<String> addLift(@RequestBody Lift lift){
        liftService.addLift(lift);
        return new ResponseEntity<>("lift added successfully", HttpStatus.OK);
    }
    @PostMapping("/addPassenger")
    public ResponseEntity<String> addPassenger(Passenger passenger){
        liftService.addPassenger(passenger);
        return new ResponseEntity<>("passenger added succedssfully", HttpStatus.OK);
    }
    @DeleteMapping("/deletePassenger")
    public ResponseEntity<String> deletePassenger(){
        liftService.deletePassenger();
        return new ResponseEntity<>("passengers are deleted", HttpStatus.OK);
    }
    @GetMapping("/numberOfPeople")
     public int MaximumNumberOfPeople(@RequestParam int wt, @RequestBody Lift lift){
        return liftService.getPeople(wt, lift);
    }
    @GetMapping("wtGreaterThanFifty")
    public int getPeople(@RequestBody Lift lift){
        return liftService.getPeoplegeterFifty(lift);
    }

}
