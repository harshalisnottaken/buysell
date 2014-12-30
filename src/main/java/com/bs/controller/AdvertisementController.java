package com.bs.controller;

import java.util.List;

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

import com.bs.domain.Advertisement;
import com.bs.service.AdvertisementService;

@Controller
@RequestMapping("/add")
@Slf4j
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value="/post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestBody Advertisement advertisement) {
		log.info("Posting Add for the user : {}", advertisement.getAddKey().getEmailId());
		advertisementService.saveAdd(advertisement);
		return new ResponseEntity<String>("Add posted Successfully", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAdds(@RequestParam(value = "email-id", required=true) String emailId ) {
        final List<Advertisement> advertisements = advertisementService.getAddsFor(emailId);
        return advertisements.isEmpty() ? new ResponseEntity<String>("No adds found for the user "+emailId,HttpStatus.NOT_FOUND) : new ResponseEntity<List<Advertisement>>(advertisements, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.POST)
	public ResponseEntity<?> getAddsForCategoryAndSubcategory(@RequestParam(value = "category", required=true) String category , @RequestParam(value = "sub-category", required=true) String subCategory ) {
         List<Advertisement> advertisements = advertisementService.getAddsForCategoryAndSubcategory(category,subCategory);
        return advertisements.isEmpty() ? new ResponseEntity<String>("No adds found for the category "+category+" and sub-category "+subCategory, HttpStatus.NOT_FOUND) : new ResponseEntity<List<Advertisement>>(advertisements, HttpStatus.OK);
	} 
	
}
