package com.khauminhduy.service;

import java.util.List;

import com.khauminhduy.domain.Client;

public interface ClientService {

	List<Client> findAll();
	
	Client findById(long id);
	
	Client save(Client client);
	
	void deleteById(long id);
	
}
