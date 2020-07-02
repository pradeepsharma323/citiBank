package com.bank.citi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.citi.model.User;
import com.bank.citi.service.UserService;

@RestController
public class CitiController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello Spring Boot";
	}
	
	
	  @RequestMapping("/user/{userId}") 
	  public User getUser(@PathVariable("userId") int userId) 
	  { 
		 
		  return userService.getDetailByID(userId); 
		  
	  }
	  
		
		  @PostMapping("/createUser") 
		  public String createUser(@RequestBody User user)
		  {
		    userService.saveUserDetails(user);
		    
		    return "User Details Succefully Inserted..";
		  
		  }
		 
	 
}
