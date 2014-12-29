package com.bs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.bs.domain.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void updatePassword(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(user.getEmailId()));
		Update update = new Update();
		update.set("password", user.getPassword());		
		mongoTemplate.updateFirst(query, update,User.class);
	}

	@Override
	public void updateUser(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(user.getEmailId()));
		Update update = new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set("mobileNumber", user.getMobileNumber());
		mongoTemplate.updateFirst(query, update,User.class);
	}
	
}
