package com.bs.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "category")
public class Category {
	@Id
	private String category;
	private List<String> subCategories;
}
