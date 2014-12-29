package com.bs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.domain.User;

@Repository
public interface UserRepository  extends CrudRepository<User, String> {}
