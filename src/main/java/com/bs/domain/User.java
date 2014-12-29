package com.bs.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "user")
public class User {
	@Id
	private String emailId;
	private String firstName;
	private String lastName;
	private String password;
	private Integer mobileNumber;
	

}
