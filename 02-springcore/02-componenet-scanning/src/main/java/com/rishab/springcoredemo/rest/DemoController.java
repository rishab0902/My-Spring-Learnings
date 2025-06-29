package com.rishab.springcoredemo.rest;

import com.rishab.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Create a private field for dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach){
        myCoach=theCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
