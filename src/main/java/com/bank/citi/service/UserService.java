package com.bank.citi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.citi.model.User;
import com.bank.citi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getDetailByID(int id) {
		return userRepository.findById(id).get();
	}
	
	public void saveUserDetails(User user) {
		 userRepository.save(user);
	}

}
