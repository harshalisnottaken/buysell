package com.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.Advertisement;
import com.bs.repository.AdvertisementRepository;
import com.google.common.collect.Lists;

@Service
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;

	public void saveAdd(Advertisement advertisement) {
		advertisementRepository.save(advertisement);
	}

	public List<Advertisement> getAddsFor(String emailId) {
		return advertisementRepository.findAll(Lists.newArrayList(emailId));
	}

}
