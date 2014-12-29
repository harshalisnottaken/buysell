package com.bs.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.domain.User;
import com.bs.service.UserRegistrationService;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		log.info("Registering User details with userName {}", user.getEmailId());
		userRegistrationService.registerUser(user);
		return new ResponseEntity<String>("User registered Successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update-password", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updatePassword(@RequestBody User user) {
		log.info("Updating password for userName {}", user.getEmailId());
		userRegistrationService.updatePassword(user);
		return new ResponseEntity<String>("Password updated Successfully for userId "+user.getEmailId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		log.info("Updating user details for userName {}", user.getEmailId());
		userRegistrationService.updateUser(user);
		return new ResponseEntity<String>("User updated Successfully for userId "+user.getEmailId(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> retrieveUser(@RequestParam(value = "email-id", required=true) String emailId) {
		log.info("Retreving user details for userName {}", emailId);
		final User user = userRegistrationService.retrieveUser(emailId);
        return (null == user) ? new ResponseEntity<String>("No user found for the userName "+emailId,HttpStatus.NOT_FOUND) : new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
