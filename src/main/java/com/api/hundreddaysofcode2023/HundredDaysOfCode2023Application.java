package com.api.hundreddaysofcode2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HundredDaysOfCode2023Application {

	public static void main(String[] args) {
		SpringApplication.run(HundredDaysOfCode2023Application.class, args);
	}

}
