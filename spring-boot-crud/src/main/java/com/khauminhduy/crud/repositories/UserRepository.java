package com.khauminhduy.crud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khauminhduy.crud.enttites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findByName(String name);

}
