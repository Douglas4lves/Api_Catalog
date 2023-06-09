package com.api.catalog.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.catalog.model.ProductModel;


@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{

	
	
}
