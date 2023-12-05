package com.vitalusus.vitalususplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VitalususPlusApplication {
	
	public static void main1(String[] args) {
		SpringApplication.run(VitalususPlusApplication.class, args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(VitalususPlusApplication.class, args);
		String pessoa = System.getProperty("user.name");
		pessoa = pessoa.toUpperCase();
		System.out.println("TRABALHA, " + pessoa + "!");
	}

}
