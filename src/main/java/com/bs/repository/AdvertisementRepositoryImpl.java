package com.bs.repository;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bs.domain.Advertisement;
import com.google.common.collect.Lists;

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

	@Override
	public List<Advertisement> searchAllAddsForRequest(HashSet<String> searchRequest) {
		List<Advertisement> adds = Lists.newArrayList();
		for(String reqQuery : searchRequest) {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id.title").regex(reqQuery, "i"));
			adds.addAll(mongoTemplate.find(query, Advertisement.class));
		}
		return adds;
	}
	
}
