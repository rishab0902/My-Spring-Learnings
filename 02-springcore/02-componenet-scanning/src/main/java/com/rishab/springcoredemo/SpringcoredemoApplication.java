package com.rishab.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(
//custom scannning of packages
	scanBasePackages = {"com.rishab.springcoredemo",
	"com.rishab.util"}
)


public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
