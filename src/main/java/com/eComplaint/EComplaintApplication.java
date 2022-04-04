package com.eComplaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//Auto-Configuration Part
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class EComplaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(EComplaintApplication.class, args);
	}
}
