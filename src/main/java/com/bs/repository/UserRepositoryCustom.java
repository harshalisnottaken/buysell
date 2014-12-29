package com.bs.repository;

import org.springframework.stereotype.Component;

import com.bs.domain.User;

@Component
public interface UserRepositoryCustom {

	public void updatePassword(User user);

	public void updateUser(User user);
}
