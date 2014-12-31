package com.bs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.domain.Advertisement;
import com.sun.xml.internal.bind.v2.model.core.ID;


@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, String> {

	@Query("{'_id.emailId' : {$in: ?0}}")
	public List<Advertisement> findAll(List<String> emailId);
	
	@Query("{'_id' : {$in: ?0}}")
	public  boolean exists(ID emailId);

}
