package com.khauminhduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khauminhduy.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
