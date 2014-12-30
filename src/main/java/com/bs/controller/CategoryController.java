package com.bs.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.service.CategoryService;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/sub-categories", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestParam(value = "category", required=true) String category) {
		log.info("Retrieving subcategories for the user : {}", category);
		List<String> subCategories = categoryService.retrieveSubCategories(category);
		return ((null == subCategories) || (subCategories.isEmpty())) ? new ResponseEntity<String>("No subCategories found for the category "+category,HttpStatus.NOT_FOUND) : new ResponseEntity<List<String>>(subCategories, HttpStatus.OK);
	}
	
	

}
