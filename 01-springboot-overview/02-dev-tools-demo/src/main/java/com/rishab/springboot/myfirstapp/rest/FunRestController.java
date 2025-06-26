package com.rishab.springboot.myfirstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World 5";
    }
    @GetMapping("/workout")
        public String getDailyWorkout(){
            return " Run a hard 5k";
        }

    @GetMapping("/workout2")
    public String getDailyWorkout2(){
        return " Run a hard 15k";
    }

    @GetMapping("/workout3")
    public String getDailyWorkout3(){
        return " Run a hard 20k";
    }

    @GetMapping("/workout4")
    public String getDailyWorkout4(){
        return " Run a hard 25k";
    }

    @GetMapping("/workout5")
    public String getDailyWorkout5(){
        return " Run a hard 10k";
    }
}
