package com.rishab.springcoredemo.rest;

import com.rishab.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Create a private field for dependency
    private Coach myCoach;

    //define a setter method for dependency injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//    }

    //constructor injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        this.myCoach=theCoach;
//    }


    //for Criect specifucally
//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
//        myCoach = theCoach;
//    }

    //for tennis one
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
        myCoach = theCoach;
    }




    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
