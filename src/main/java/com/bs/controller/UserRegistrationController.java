package com.bs.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.domain.User;
import com.bs.service.UserRegistrationService;

@Controller
@Slf4j
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(value="/register-user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		log.info("Registering User details");
		userRegistrationService.registerUser(user);
		return new ResponseEntity<String>("User registered Successfully", HttpStatus.OK);
		
	}

}
