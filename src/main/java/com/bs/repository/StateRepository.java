package com.bs.repository;

import org.springframework.data.repository.CrudRepository;

import com.bs.domain.State;

public interface StateRepository extends CrudRepository<State, String> {

}
