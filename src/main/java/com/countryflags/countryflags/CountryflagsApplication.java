package com.countryflags.countryflags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.countryflags.controllers", "come.countryflags.models"})
public class CountryflagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryflagsApplication.class, args);
	}

}
