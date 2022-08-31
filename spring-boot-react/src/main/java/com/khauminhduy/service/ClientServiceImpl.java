package com.khauminhduy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khauminhduy.domain.Client;
import com.khauminhduy.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(long id) {
		return clientRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteById(long id) {
		clientRepository.deleteById(id);
	}
	
	
	
}
