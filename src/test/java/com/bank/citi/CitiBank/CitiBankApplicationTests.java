package com.bank.citi.CitiBank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.bank.citi.CitiBankApplication;
import com.bank.citi.model.User;

@SpringBootTest(classes = CitiBankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitiBankApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(getRootUrl() + "/users/101", User.class);
		System.out.println(user.getFirstName());
		Assert.notNull(user);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserId(106);
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setGender("male");
		user.setAge("20");
		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
		Assert.notNull(postResponse);
		Assert.notNull(postResponse.getBody());
	}


}