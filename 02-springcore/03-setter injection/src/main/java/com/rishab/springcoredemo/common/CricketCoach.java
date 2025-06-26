package com.rishab.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 16 minutes+!!";

    }
}
