package com.api.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.catalog.model.CategoryModel;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{

	boolean existsByName(String name);
	
}
