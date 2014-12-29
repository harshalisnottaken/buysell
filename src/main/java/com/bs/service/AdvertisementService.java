package com.bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.Advertisement;
import com.bs.repository.AdvertisementRepository;

@Service
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;

	public void saveAdd(Advertisement advertisement) {
		advertisementRepository.save(advertisement);
	}

}
