package com.bs.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bs.domain.Advertisement;

@Component
public interface AdvertisementRepositoryCustom {
	public List<Advertisement> getAddsForCategoryAndSubcategory(
			String category, String subCategory);
}
