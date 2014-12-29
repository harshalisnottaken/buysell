package com.bs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.domain.Advertisement;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, String> {
	
	 @Query("{'emailId' : {$in: ?0}}")
	 public List<Advertisement> findAll(List<String> emailId);

}
