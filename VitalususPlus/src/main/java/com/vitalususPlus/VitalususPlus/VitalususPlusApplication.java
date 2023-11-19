package com.vitalususPlus.VitalususPlus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VitalususPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalususPlusApplication.class, args);
		String pessoa = System.getProperty("user.name");
		pessoa = pessoa.toUpperCase();
		System.out.println("TRABALHA, " + pessoa + "!");
	}

}
