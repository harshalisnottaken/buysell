package com.bs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bs.domain.Category;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, String> {

}
