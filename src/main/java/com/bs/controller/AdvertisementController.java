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

import com.bs.domain.Advertisement;
import com.bs.service.AdvertisementService;

@Controller
@Slf4j
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value="/post-add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestBody Advertisement advertisement) {
		log.info("Posting Add for the user : {}", advertisement.getEmailId());
		advertisementService.saveAdd(advertisement);
		return new ResponseEntity<String>("Add posted Successfully", HttpStatus.OK);
	}
	
}
