package com.bs.domain;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@Document(collection = "add")
public class Advertisement {
	@Id
	private AddKey addKey;
	private String category;
	private String subCategory;
	private String description;  
	private String photo; //type should be decided
	private Double price;
	private Long mobileNumber;
	private DateTime availableFromTime;
	private DateTime availableToTime;
	private String state;
	private String city;
}
