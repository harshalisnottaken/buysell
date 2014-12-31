package com.bs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.AddKey;
import com.bs.domain.Advertisement;
import com.bs.repository.AdvertisementRepository;
import com.bs.repository.AdvertisementRepositoryCustom;
import com.bs.util.StringUpperCaseLowerCaseConverter;
import com.google.common.collect.Lists;

@Service
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private AdvertisementRepositoryCustom  advertisementRepositoryCustom;

	public void saveAdd(Advertisement advertisement) {
		enrichAdvertisement(advertisement);
		advertisementRepository.save(advertisement);
	}

	private void enrichAdvertisement(Advertisement advertisement) {
		String emailIdLowerCase = StringUpperCaseLowerCaseConverter.convertToLowerCase(advertisement.getAddKey().getEmailId());
		AddKey addKey = new AddKey();
		addKey.setEmailId(emailIdLowerCase);
		addKey.setTitle(advertisement.getAddKey().getTitle());
		advertisement.setAddKey(addKey);
		advertisement.setState(StringUpperCaseLowerCaseConverter.convertToUpperCase(advertisement.getState()));
		advertisement.setCity(StringUpperCaseLowerCaseConverter.convertToUpperCase(advertisement.getCity()));
		advertisement.setCategory(StringUpperCaseLowerCaseConverter.convertToUpperCase(advertisement.getCategory()));
		advertisement.setSubCategory(StringUpperCaseLowerCaseConverter.convertToUpperCase(advertisement.getSubCategory()));
	}

	public List<Advertisement> getAddsFor(String emailId) {
		return advertisementRepository.findAll(Lists.newArrayList(StringUpperCaseLowerCaseConverter.convertToLowerCase(emailId)));
	}

	public List<Advertisement> getAddsForCategoryAndSubcategory(
			String category, String subCategory) {
		return advertisementRepositoryCustom.getAddsForCategoryAndSubcategory(StringUpperCaseLowerCaseConverter.convertToUpperCase(category),StringUpperCaseLowerCaseConverter.convertToUpperCase(subCategory));
	}

	public Set<Advertisement> searchAllAddsForRequest(String searchReq) {
		String[] splitStr = searchReq.split("\\s+");
		return advertisementRepositoryCustom.searchAllAddsForRequest(splitStr);
	}

}
