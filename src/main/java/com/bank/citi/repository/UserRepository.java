package com.bank.citi.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.citi.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}
