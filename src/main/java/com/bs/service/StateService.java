package com.bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.State;
import com.bs.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public State retrieveCities(String state) {
		return stateRepository.findOne(state.toUpperCase());
	}

}
