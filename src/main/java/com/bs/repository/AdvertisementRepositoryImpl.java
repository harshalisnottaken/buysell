package com.bs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bs.domain.Advertisement;

public class AdvertisementRepositoryImpl implements
		AdvertisementRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Advertisement> getAddsForCategoryAndSubcategory(
			String category, String subCategory) {
		Query query = new Query();
		query.addCriteria(Criteria.where("category").is(category)).addCriteria(Criteria.where("subCategory").is(subCategory));
		 List<Advertisement> adds = mongoTemplate.find(query, Advertisement.class);
		 return adds;
	}

}
