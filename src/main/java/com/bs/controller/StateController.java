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

import com.bs.domain.State;
import com.bs.service.StateService;

@Controller
@RequestMapping("/state")
@Slf4j
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@RequestMapping(value="/cities", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> retrieveCities(@RequestParam(value = "state", required=true) String state) {
		log.info("Retrieving cities for the state : {}", state);
		State response = stateService.retrieveCities(state);
		return ((null== response) || (null == response.getCities()) || (response.getCities().isEmpty())) ? new ResponseEntity<String>("No cities found for the state "+state,HttpStatus.NOT_FOUND) : new ResponseEntity<List<String>>(response.getCities(), HttpStatus.OK);
	}

}
