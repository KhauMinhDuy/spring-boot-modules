package com.khauminhduy.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.khauminhduy.domain.Client;
import com.khauminhduy.service.ClientService;

@Component
public class BoostrapInitialData implements CommandLineRunner {

	@Autowired
	private ClientService clientService;
	
	private Faker faker = new Faker(Locale.getDefault());
	
	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i < 10; i++) {
			clientService.save(new Client(faker.name().fullName(), faker.internet().emailAddress()));
		}
	}

}
