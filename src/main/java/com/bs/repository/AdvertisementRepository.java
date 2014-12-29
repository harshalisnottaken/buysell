package com.bs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.domain.Advertisement;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, String> {

}
