package com.luv2code.springcoredemo.config;


import com.luv2code.springcoredemo.common.BaseballCoach;
import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
//    @Bean
    //to give custom bean id
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
