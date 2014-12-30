package com.bs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.Advertisement;
import com.bs.repository.AdvertisementRepository;
import com.bs.repository.AdvertisementRepositoryCustom;
import com.google.common.collect.Lists;

@Service
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private AdvertisementRepositoryCustom  advertisementRepositoryCustom;

	public void saveAdd(Advertisement advertisement) {
		advertisementRepository.save(advertisement);
	}

	public List<Advertisement> getAddsFor(String emailId) {
		return advertisementRepository.findAll(Lists.newArrayList(emailId));
	}

	public List<Advertisement> getAddsForCategoryAndSubcategory(
			String category, String subCategory) {
		return advertisementRepositoryCustom.getAddsForCategoryAndSubcategory(category,subCategory);
	}

	public Set<Advertisement> searchAllAddsForRequest(String searchReq) {
		String[] splitStr = searchReq.split("\\s+");
		return advertisementRepositoryCustom.searchAllAddsForRequest(splitStr);
	}

}
